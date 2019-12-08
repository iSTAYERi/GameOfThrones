package ru.skillbranch.gameofthrones.data.local.entities

import io.realm.RealmObject

open class House(
    var id: String? = null,
    var name: String? = null,
    var region: String? = null,
    var coatOfArms: String? = null,
    var words: String? = null,
    var titles: List<String>? = null,
    var seats: List<String>? = null,
    var currentLord: String? = null, //rel
    var heir: String? = null, //rel
    var overlord: String? = null,
    var founded: String? = null,
    var founder: String? = null, //rel
    var diedOut: String? = null,
    var ancestralWeapons: List<String>? = null
) : RealmObject()