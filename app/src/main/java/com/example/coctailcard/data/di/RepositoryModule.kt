package com.example.coctailcard.data.di

import com.example.coctailcard.data.repositories.GetCocktailsRepository
import com.example.coctailcard.data.repositories.GetCocktailsRepositoryImpl
import com.example.coctailcard.data.repositories.alcoholic.AlcoholicCocktailsRepository
import com.example.coctailcard.data.repositories.alcoholic.AlcoholicCocktailsRepositoryImpl
import com.example.coctailcard.data.repositories.favorites.FavoriteRepository
import com.example.coctailcard.data.repositories.favorites.FavoriteRepositoryImpl
import com.example.coctailcard.data.repositories.glasses.GetGlassesRepository
import com.example.coctailcard.data.repositories.glasses.GetGlassesRepositoryImpl
import com.example.coctailcard.data.repositories.ingredients.GetIngredientsRepository
import com.example.coctailcard.data.repositories.ingredients.GetIngredientsRepositoryImpl
import com.example.coctailcard.data.repositories.nonalcoholic.NonAlcoholicCocktailsRepository
import com.example.coctailcard.data.repositories.nonalcoholic.NonAlcoholicCocktailsRepositoryImpl
import org.koin.core.KoinApplication
import org.koin.dsl.module


fun KoinApplication.repositoryModule() = module {
    factory<GetCocktailsRepository> { GetCocktailsRepositoryImpl(get()) }
    factory<AlcoholicCocktailsRepository> { AlcoholicCocktailsRepositoryImpl(get()) }
    factory<NonAlcoholicCocktailsRepository> { NonAlcoholicCocktailsRepositoryImpl(get()) }
    factory<GetGlassesRepository> { GetGlassesRepositoryImpl(get()) }
    factory<GetIngredientsRepository> { GetIngredientsRepositoryImpl(get()) }
    factory<FavoriteRepository> { FavoriteRepositoryImpl(get()) }
}
