package com.example.coctailcard.data.repositories.alcoholic

import com.example.coctailcard.data.network.RequestResult
import com.example.coctailcard.data.network.models.Cocktail

interface AlcoholicCocktailsRepository {
    suspend fun getAlcoholicCoctails(): RequestResult<List<Cocktail>>
}