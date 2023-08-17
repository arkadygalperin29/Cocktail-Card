package com.example.coctailcard.data.repositories.nonalcoholic

import com.example.network.RequestResult
import com.example.domain.Cocktail

interface NonAlcoholicCocktailsRepository {
    suspend fun getNonAlcoholicCocktails(): RequestResult<List<Cocktail>>
}