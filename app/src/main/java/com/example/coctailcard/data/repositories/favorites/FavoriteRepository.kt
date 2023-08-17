package com.example.coctailcard.data.repositories.favorites

import com.example.domain.Cocktail

interface FavoriteRepository {

    fun getAllFavoriteDrinks(): List<Cocktail>

    suspend fun saveFavoriteDrink(cocktailMain: Cocktail)

    suspend fun deleteFavoriteDrink(cocktailMain: Cocktail)

    suspend fun getCocktailById(id: String): Cocktail?
}