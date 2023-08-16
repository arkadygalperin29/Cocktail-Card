package com.example.coctailcard.data.di

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.coctailcard.data.db.dao.SampleDataDao
import com.example.coctailcard.domain.models.SampleData
import org.koin.core.KoinApplication
import org.koin.dsl.module

fun KoinApplication.databaseModule() = module {
    single<Db> {
        Room.databaseBuilder(
            get(),
            Db::class.java, "database-name"
        ).fallbackToDestructiveMigrationOnDowngrade()
            .build()
    }
    single { get<Db>().sampleDao() }
}

@Database(
    entities = [
        SampleData::class
    ],
    version = 1,
    exportSchema = true,
    autoMigrations = []
)
abstract class Db : RoomDatabase() {
    abstract fun sampleDao(): SampleDataDao
}
