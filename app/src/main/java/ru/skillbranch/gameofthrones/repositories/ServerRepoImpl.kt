package ru.skillbranch.gameofthrones.repositories

import ru.skillbranch.gameofthrones.repositories.server.ServerApi

class ServerRepoImpl(private val serverApi: ServerApi): ServerRepo {

    override fun getAllHouses() = serverApi.getAllHouses()

    override fun getNeedHouses(needHouses: List<String>) = serverApi.getNeedHouses(needHouses)

    override fun getNeedHouseWithCharacters(needHouses: List<String>) =
        serverApi.getNeedHousesWithCharacters(needHouses)

}