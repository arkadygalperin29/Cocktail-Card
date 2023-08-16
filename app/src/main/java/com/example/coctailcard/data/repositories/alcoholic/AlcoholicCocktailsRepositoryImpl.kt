package com.example.coctailcard.data.repositories.alcoholic

import com.example.coctailcard.data.network.ApiService
import com.example.coctailcard.data.network.RequestResult
import com.example.coctailcard.domain.models.Cocktail

class AlcoholicCocktailsRepositoryImpl(private val apiService: ApiService) :
    AlcoholicCocktailsRepository {
    override suspend fun getAlcoholicCoctails(): RequestResult<List<Cocktail>> {
        return runCatching {
            apiService.getCocktailsWithAlcohol().data
                ?: throw IllegalStateException("Can't load the alcoholic cocktails")
        }.fold(
            onSuccess = { RequestResult.Success(it) },
            onFailure = { RequestResult.Error(it) }
        )
    }
}