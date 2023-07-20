package com.example.coctailcard.data.di

import android.content.Context
import org.koin.core.context.GlobalContext.startKoin

fun Context.configureKoin() {
    startKoin {
        applicationModule(this@configureKoin)
        modules(
            restModule(),
            coilModule(),
            databaseModule()
        )
    }
}