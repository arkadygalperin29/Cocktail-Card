package com.example.coctailcard.data.repositories.nonalcoholic

import com.example.coctailcard.data.network.ApiService
import com.example.coctailcard.data.network.RequestResult
import com.example.coctailcard.data.network.models.NonAlcoholicCocktail

class NonAlcoholicCocktailsRepositoryImpl(private val apiService: ApiService) :
    NonAlcoholicCocktailsRepository {
    override suspend fun getNonAlcoholicCocktails(): RequestResult<List<NonAlcoholicCocktail>> {
        return runCatching {
            apiService.getNonAlcoholicCocktails().data
                ?: throw IllegalStateException("Can't load the non alcoholic cocktail list")
        }.fold(
            onSuccess = { RequestResult.Success(it) },
            onFailure = { RequestResult.Error(it) }
        )
    }
}