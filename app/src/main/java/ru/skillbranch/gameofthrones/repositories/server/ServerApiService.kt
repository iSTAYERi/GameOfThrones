package ru.skillbranch.gameofthrones.repositories.server

import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.Url
import ru.skillbranch.gameofthrones.data.remote.res.CharacterRes
import ru.skillbranch.gameofthrones.data.remote.res.HouseRes

interface ServerApiService {

    @GET("houses")
    fun getAllHouses(
        @Query("page") page: Int,
        @Query("pageSize") pageSize: Int = 50
    ): Single<List<HouseRes>>

    @GET("houses")
    fun getNeedHouse(
        @Query("name") houseName: String
    ): Single<List<HouseRes>>

    @GET
    fun getCharacters(
        @Url url: String
    ): Single<CharacterRes>
}