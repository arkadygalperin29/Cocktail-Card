package com.example.coctailcard.data.repositories.alcoholic

import com.example.network.RequestResult
import com.example.domain.Cocktail

interface AlcoholicCocktailsRepository {
    suspend fun getAlcoholicCoctails(): RequestResult<List<Cocktail>>
}