package ru.skillbranch.gameofthrones.repositories

import io.realm.Realm
import ru.skillbranch.gameofthrones.data.local.entities.CharacterFull
import ru.skillbranch.gameofthrones.data.local.entities.CharacterItem
import ru.skillbranch.gameofthrones.data.remote.res.CharacterRes
import ru.skillbranch.gameofthrones.data.remote.res.HouseRes

interface RealmRepo {
    fun insertHouses(realm: Realm, houses : List<HouseRes>)
    fun insertCharacters(realm: Realm, characters : List<CharacterRes>)
    fun dropDb(realm: Realm)
    fun findCharactersByHouseName(realm: Realm, name : String): List<CharacterItem>
    fun findCharacterFullById(realm: Realm, id : String): CharacterFull
    fun isNeedUpdate(realm: Realm): Boolean
}