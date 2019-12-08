package ru.skillbranch.gameofthrones.repositories.server

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import io.reactivex.Observable
import io.reactivex.Single
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import ru.skillbranch.gameofthrones.AppConfig
import ru.skillbranch.gameofthrones.data.remote.res.CharacterRes
import ru.skillbranch.gameofthrones.data.remote.res.HouseRes

interface ServerApi {
    fun getAllHouses(): Single<List<HouseRes>>
    fun getNeedHouses(needHouses: List<String>): Single<List<HouseRes>>
    fun getNeedHousesWithCharacters(
        needHouses: List<String>
    ): Single<List<Pair<HouseRes, List<CharacterRes>>>>
}

class ServerApiImpl: ServerApi {

    private val logInterceptor = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }

    private val httpClient = OkHttpClient.Builder()
        .addInterceptor(logInterceptor)
        .build()

    private val moshi = Moshi.Builder()
        .add(KotlinJsonAdapterFactory())
        .build()

    private val retrofit = Retrofit.Builder()
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .baseUrl(AppConfig.BASE_URL)
        .client(httpClient)
        .build()

    private val serverApiService = retrofit.create(ServerApiService::class.java)

    override fun getAllHouses(): Single<List<HouseRes>> {
        val result = mutableListOf<HouseRes>()
        Observable.fromIterable(1..9)
            .flatMapSingle { serverApiService.getAllHouses(it) }
            .doOnNext { result.addAll(it) }
        return Single.just(result)
    }

    override fun getNeedHouses(needHouses: List<String>): Single<List<HouseRes>> {
        val result = mutableListOf<HouseRes>()
        Observable.fromIterable(needHouses)
            .flatMapSingle { serverApiService.getNeedHouse(it) }
            .blockingForEach { result.addAll(it) }
        return Single.just(result)
    }

    override fun getNeedHousesWithCharacters(needHouses: List<String>): Single<List<Pair<HouseRes, List<CharacterRes>>>> {
        var resultMap = mutableMapOf<HouseRes, MutableList<CharacterRes>>()
        lateinit var house: HouseRes
        getNeedHouses(needHouses)
            .flatMapObservable { Observable.fromIterable(it) }
            .flatMap {
                house = it
                resultMap[house] = mutableListOf()
                Observable.fromIterable(it.swornMembers)
            }
            .flatMapSingle { serverApiService.getCharacters(it) }
            .blockingForEach { resultMap[house]!!.add(it) }
        return Single.just(resultMap.toList())
    }

}