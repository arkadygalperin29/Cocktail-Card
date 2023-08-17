package com.example.coctailcard.data.repositories.nonalcoholic

import com.example.network.ApiService
import com.example.network.RequestResult
import com.example.domain.Cocktail

class NonAlcoholicCocktailsRepositoryImpl(private val apiService: ApiService) :
    NonAlcoholicCocktailsRepository {
    override suspend fun getNonAlcoholicCocktails(): RequestResult<List<Cocktail>> {
        return runCatching {
            apiService.getNonAlcoholicCocktails().data
                ?: throw IllegalStateException("Can't load the non alcoholic cocktail list")
        }.fold(
            onSuccess = { RequestResult.Success(it) },
            onFailure = { RequestResult.Error(it) }
        )
    }
}