package com.example.coctailcard.data.repositories.nonalcoholic

import com.example.coctailcard.data.network.RequestResult
import com.example.coctailcard.data.network.models.NonAlcoholicCocktail

interface NonAlcoholicCocktailsRepository {
    suspend fun getNonAlcoholicCocktails(): RequestResult<List<NonAlcoholicCocktail>>
}