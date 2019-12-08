package ru.skillbranch.gameofthrones.di

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import ru.skillbranch.gameofthrones.repositories.RealmRepo
import ru.skillbranch.gameofthrones.repositories.RealmRepoImpl
import ru.skillbranch.gameofthrones.repositories.ServerRepo
import ru.skillbranch.gameofthrones.repositories.ServerRepoImpl
import ru.skillbranch.gameofthrones.repositories.server.ServerApi
import ru.skillbranch.gameofthrones.repositories.server.ServerApiImpl
import ru.skillbranch.gameofthrones.viewmodels.CharacterViewModel
import ru.skillbranch.gameofthrones.viewmodels.HousesViewModel
import ru.skillbranch.gameofthrones.viewmodels.SplashViewModel

val appModule = module {
    single<ServerApi> { ServerApiImpl() }
    single<ServerRepo> { ServerRepoImpl(get()) }
    single<RealmRepo> { RealmRepoImpl() }
    viewModel { CharacterViewModel() }
    viewModel { HousesViewModel() }
    viewModel { SplashViewModel() }
}