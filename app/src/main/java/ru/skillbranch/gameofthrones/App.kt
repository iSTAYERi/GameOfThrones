package ru.skillbranch.gameofthrones

import android.app.Application
import io.realm.Realm
import io.realm.RealmConfiguration
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import ru.skillbranch.gameofthrones.db.Migration
import ru.skillbranch.gameofthrones.di.appModule

class App: Application() {

    companion object {
        const val DATABASE_SCHEMA_VERSION = 0L
    }

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@App)
            modules(appModule)
        }

        //TODO убрать deleteRealmIfMigrationNeeded() в итоговой версии.
        Realm.init(this)
        val realmConfig = RealmConfiguration.Builder()
            .schemaVersion(DATABASE_SCHEMA_VERSION)
            .deleteRealmIfMigrationNeeded()
            .migration(Migration())
            .build()
        Realm.setDefaultConfiguration(realmConfig)
    }

}