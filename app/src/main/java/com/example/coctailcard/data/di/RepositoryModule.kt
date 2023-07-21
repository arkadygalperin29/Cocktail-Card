package com.example.coctailcard.data.di

import com.example.coctailcard.data.repositories.GetCocktailsRepository
import com.example.coctailcard.data.repositories.GetCocktailsRepositoryImpl
import org.koin.core.KoinApplication
import org.koin.dsl.module

fun KoinApplication.repositoryModule() = module {
    factory<GetCocktailsRepository> { GetCocktailsRepositoryImpl(get()) }
}