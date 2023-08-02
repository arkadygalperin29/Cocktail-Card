package com.example.coctailcard.data.repositories

import com.example.coctailcard.data.network.RequestResult
import com.example.coctailcard.data.network.models.Cocktail

interface GetCocktailsRepository {
    suspend fun getCocktailsByFirstLetter(letterSearch: String): RequestResult<List<Cocktail>>
    suspend fun getCocktailById(id: String): RequestResult<List<Cocktail>>
}