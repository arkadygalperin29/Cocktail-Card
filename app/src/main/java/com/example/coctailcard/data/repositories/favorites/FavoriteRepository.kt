package com.example.coctailcard.data.repositories.favorites

import com.example.coctailcard.domain.models.Cocktail
import com.example.coctailcard.domain.models.CocktailMain
import kotlinx.coroutines.flow.Flow

interface FavoriteRepository {

    fun getAllFavoriteDrinks(): List<Cocktail>

    suspend fun saveFavoriteDrink(cocktailMain: Cocktail)

    suspend fun deleteFavoriteDrink(cocktailMain: Cocktail)
}