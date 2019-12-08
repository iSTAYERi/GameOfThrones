package ru.skillbranch.gameofthrones.repositories

import io.realm.Realm
import ru.skillbranch.gameofthrones.data.local.entities.CharacterFull
import ru.skillbranch.gameofthrones.data.local.entities.CharacterItem
import ru.skillbranch.gameofthrones.data.remote.res.CharacterRes
import ru.skillbranch.gameofthrones.data.remote.res.HouseRes

class RealmRepoImpl: RealmRepo {

    override fun insertHouses(realm: Realm, houses: List<HouseRes>) {
        realm
    }

    override fun insertCharacters(realm: Realm, characters: List<CharacterRes>) {
        TODO("not implemented")
    }

    override fun dropDb(realm: Realm) {
        TODO("not implemented")
    }

    override fun findCharactersByHouseName(realm: Realm, name: String): List<CharacterItem> {
        TODO("not implemented")
    }

    override fun findCharacterFullById(realm: Realm, id: String): CharacterFull {
        TODO("not implemented")
    }

    override fun isNeedUpdate(realm: Realm): Boolean {
        TODO("not implemented")
    }
}