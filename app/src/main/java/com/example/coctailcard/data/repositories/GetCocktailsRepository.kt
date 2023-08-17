package com.example.coctailcard.data.repositories

import com.example.network.RequestResult
import com.example.domain.Cocktail

interface GetCocktailsRepository {
    suspend fun getCocktailsByFirstLetter(letterSearch: String): RequestResult<List<Cocktail>>
    suspend fun getCocktailById(id: String): RequestResult<List<Cocktail>>
}