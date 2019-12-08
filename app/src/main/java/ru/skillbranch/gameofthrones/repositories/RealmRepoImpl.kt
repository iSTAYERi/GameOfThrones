package ru.skillbranch.gameofthrones.repositories

import io.realm.Realm
import io.realm.RealmList
import io.realm.kotlin.where
import ru.skillbranch.gameofthrones.data.local.entities.*
import ru.skillbranch.gameofthrones.data.remote.res.CharacterRes
import ru.skillbranch.gameofthrones.data.remote.res.HouseRes
import ru.skillbranch.gameofthrones.extensions.getIdFromUrl

class RealmRepoImpl: RealmRepo {

    override fun insertHouses(realm: Realm, houses: List<HouseRes>) {
        val newHouses = houses.map { with(it) {
            House(
                url.getIdFromUrl(),
                name, region, coatOfArms, words,
                titles.mapTo(RealmList(), { string -> string }),
                seats.mapTo(RealmList(), { string -> string }),
                currentLord, heir, overlord, founded, founder, diedOut,
                ancestralWeapons.mapTo(RealmList(), { string -> string }),
                HouseRes.getHouseId(name)
            )
        } }
        realm.executeTransaction { it.insertOrUpdate(newHouses) }
    }

    override fun insertCharacters(realm: Realm, characters: List<CharacterRes>) {
        val newChars = characters.map { with(it) {
            Character(
                url.getIdFromUrl(),
                houseId, name, gender, culture, born, died,
                titles.mapTo(RealmList(), { string -> string }),
                aliases.mapTo(RealmList(), { string -> string }),
                father, mother, spouse
            )
        } }
        realm.executeTransaction { it.insertOrUpdate(newChars) }
    }

    override fun findCharactersByHouseName(realm: Realm, name: String): List<CharacterItem> {
        val chars = realm.where<Character>().equalTo("houseId", name).findAll()
        return chars.map { with(it) {
            CharacterItem(id, houseId, it.name, titles, aliases)
        } }
    }

    override fun findCharacterFullById(realm: Realm, id: String): CharacterFull {
        with(realm.where<Character>().equalTo("id", id).findFirst()) {
            val house = realm.where<House>().equalTo("houseId", id).findFirst()
            val father = realm.where<Character>()
                .equalTo("id", this?.father?.getIdFromUrl()).findFirst()
            val mother = realm.where<Character>()
                .equalTo("id", this?.mother?.getIdFromUrl()).findFirst()
            return CharacterFull(
                id, this?.name, house?.words, this?.born,
                this?.died, this?.titles, this?.aliases, house?.name,
                RelativeCharacter(father?.id, father?.name, father?.houseId),
                RelativeCharacter(mother?.id, mother?.name, mother?.houseId)
            )
        }
    }


    override fun dropDb(realm: Realm) = realm.executeTransaction { it.deleteAll() }

    override fun isNeedUpdate(realm: Realm) = realm.isEmpty

}