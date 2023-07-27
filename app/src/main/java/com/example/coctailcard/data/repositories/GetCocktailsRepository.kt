package com.example.coctailcard.data.repositories

import com.example.coctailcard.data.network.RequestResult
import com.example.coctailcard.data.network.models.Cocktail

interface GetCocktailsRepository {
    suspend fun getCocktailsByFirstLetter(): RequestResult<List<Cocktail>>
    suspend fun getCocktailById(id: Int): RequestResult<Cocktail>
}