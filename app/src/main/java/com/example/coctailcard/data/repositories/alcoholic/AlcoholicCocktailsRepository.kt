package com.example.coctailcard.data.repositories.alcoholic

import com.example.coctailcard.data.network.RequestResult
import com.example.coctailcard.data.network.models.AlcoholicCocktail

interface AlcoholicCocktailsRepository {
    suspend fun getAlcoholicCoctails(): RequestResult<List<AlcoholicCocktail>>
}