package com.example.coctailcard.data.repositories.nonalcoholic

import com.example.coctailcard.data.network.RequestResult
import com.example.coctailcard.data.network.models.Cocktail

interface NonAlcoholicCocktailsRepository {
    suspend fun getNonAlcoholicCocktails(): RequestResult<List<Cocktail>>
}