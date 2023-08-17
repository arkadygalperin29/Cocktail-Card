package com.example.coctailcard.data.di

import com.example.network.ApiService
import com.example.coctailcard.util.Cfg
import com.google.gson.Gson
import okhttp3.ConnectionPool
import okhttp3.CookieJar
import okhttp3.JavaNetCookieJar
import okhttp3.OkHttpClient
import org.koin.core.KoinApplication
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.net.CookieManager
import java.net.CookiePolicy
import java.util.concurrent.TimeUnit

fun KoinApplication.restModule() = module {
    single { Gson() }
    single<CookieJar> {
        JavaNetCookieJar(CookieManager().apply {
            setCookiePolicy(CookiePolicy.ACCEPT_ALL)
        })
    }
    single {
        OkHttpClient.Builder()
            .cookieJar(get())
            .connectTimeout(15, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .connectionPool(ConnectionPool(10, 30, TimeUnit.SECONDS))
            .build()
    }

    single {
        Retrofit.Builder()
            .baseUrl(Cfg.API_URL)
            .client(get())
            .addConverterFactory(GsonConverterFactory.create(get()))
            .build()
    }

    single {
        get<Retrofit>().create(ApiService::class.java)
    }
}