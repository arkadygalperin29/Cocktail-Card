package com.example.coctailcard.data.di

import androidx.room.AutoMigration
import androidx.room.Database
import androidx.room.DeleteTable
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.migration.AutoMigrationSpec
import com.example.coctailcard.data.db.dao.CocktailDao
import com.example.coctailcard.data.db.dao.SampleDataDao
import com.example.domain.Cocktail
import com.example.domain.SampleData
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
    single { get<Db>().cocktailDao() }
}

@Database(
    entities = [
        SampleData::class,
        Cocktail::class
    ],
    version = 1,
    exportSchema = true,
    autoMigrations = []
)
abstract class Db : RoomDatabase() {
    abstract fun sampleDao(): SampleDataDao
    abstract fun cocktailDao(): CocktailDao
}
