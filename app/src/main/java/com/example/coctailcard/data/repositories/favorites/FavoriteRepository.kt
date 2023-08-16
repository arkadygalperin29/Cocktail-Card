package com.example.coctailcard.data.repositories.favorites

import com.example.coctailcard.domain.models.CocktailMain
import kotlinx.coroutines.flow.Flow

interface FavoriteRepository {

    fun getAllFavoriteDrinks(): Flow<List<CocktailMain>>

    suspend fun saveFavoriteDrink(cocktailMain: CocktailMain)

    suspend fun deleteFavoriteDrink(cocktailMain: CocktailMain)
}