package com.example.coctailcard.data.di

import com.example.coctailcard.data.repositories.GetCocktailsRepository
import com.example.coctailcard.data.repositories.GetCocktailsRepositoryImpl
import com.example.coctailcard.data.repositories.alcoholic.AlcoholicCocktailsRepository
import com.example.coctailcard.data.repositories.alcoholic.AlcoholicCocktailsRepositoryImpl
import com.example.coctailcard.data.repositories.nonalcoholic.NonAlcoholicCocktailsRepository
import com.example.coctailcard.data.repositories.nonalcoholic.NonAlcoholicCocktailsRepositoryImpl
import org.koin.core.KoinApplication
import org.koin.dsl.module


fun KoinApplication.repositoryModule() = module {
    factory<GetCocktailsRepository> { GetCocktailsRepositoryImpl(get()) }
    factory<AlcoholicCocktailsRepository> { AlcoholicCocktailsRepositoryImpl(get()) }
    factory<NonAlcoholicCocktailsRepository> { NonAlcoholicCocktailsRepositoryImpl(get()) }
}
