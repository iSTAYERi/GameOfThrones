package ru.skillbranch.gameofthrones.data.local.entities

import io.realm.RealmList
import io.realm.RealmObject

open class Character(
    var id: String? = null,
    var houseId: String? = null,
    var name: String? = null,
    var gender: String? = null,
    var culture: String? = null,
    var born: String? = null,
    var died: String? = null,
    var titles: RealmList<String>? = null,
    var aliases: RealmList<String>? = null,
    var father: String? = null, //rel
    var mother: String? = null, //rel
    var spouse: String? = null
): RealmObject()

data class CharacterItem(
    val id: String?,
    val house: String?, //rel
    val name: String?,
    val titles: List<String>?,
    val aliases: List<String>?
)

data class CharacterFull(
    val id: String? = null,
    val name: String? = null,
    val words: String? = null,
    val born: String? = null,
    val died: String? = null,
    val titles: List<String>? = null,
    val aliases: List<String>? = null,
    val house:String? = null, //rel
    val father: RelativeCharacter? = null,
    val mother: RelativeCharacter? = null
)

data class RelativeCharacter(
    val id: String?,
    val name: String?,
    val house:String? //rel
)