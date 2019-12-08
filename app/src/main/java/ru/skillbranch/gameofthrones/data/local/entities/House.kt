package ru.skillbranch.gameofthrones.data.local.entities

import io.realm.RealmList
import io.realm.RealmObject

open class House(
    var id: String? = null,
    var name: String? = null,
    var region: String? = null,
    var coatOfArms: String? = null,
    var words: String? = null,
    var titles: RealmList<String>? = null,
    var seats: RealmList<String>? = null,
    var currentLord: String? = null, //rel
    var heir: String? = null, //rel
    var overlord: String? = null,
    var founded: String? = null,
    var founder: String? = null, //rel
    var diedOut: String? = null,
    var ancestralWeapons: RealmList<String>? = null,
    var houseId: String? = null
) : RealmObject()