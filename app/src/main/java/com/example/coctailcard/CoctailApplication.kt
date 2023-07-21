package com.example.coctailcard

import android.app.Application
import coil.Coil
import com.example.coctailcard.data.di.configureKoin
import com.jakewharton.threetenabp.AndroidThreeTen
import org.koin.android.ext.android.get
import org.koin.core.component.KoinComponent


class CoctailApplication: Application(), KoinComponent {

    override fun onCreate() {
        super.onCreate()
        configureKoin()
        Coil.setImageLoader(factory = get())
        AndroidThreeTen.init(this)
    }
}