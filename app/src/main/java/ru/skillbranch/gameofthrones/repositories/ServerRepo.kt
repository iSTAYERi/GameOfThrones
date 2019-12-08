package ru.skillbranch.gameofthrones.repositories

import io.reactivex.Single
import ru.skillbranch.gameofthrones.data.remote.res.CharacterRes
import ru.skillbranch.gameofthrones.data.remote.res.HouseRes

interface ServerRepo {
    fun getAllHouses(): Single<List<HouseRes>>
    fun getNeedHouses(needHouses: List<String>): Single<List<HouseRes>>
    fun getNeedHouseWithCharacters(
        needHouses: List<String>
    ) : Single<List<Pair<HouseRes, List<CharacterRes>>>>
}