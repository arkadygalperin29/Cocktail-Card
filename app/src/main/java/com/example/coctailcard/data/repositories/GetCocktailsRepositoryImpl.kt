package com.example.coctailcard.data.repositories

import com.example.coctailcard.data.network.ApiService
import com.example.coctailcard.data.network.RequestResult
import com.example.coctailcard.data.network.models.Cocktail

class GetCocktailsRepositoryImpl(
    private val apiService: ApiService
) : GetCocktailsRepository {
    override suspend fun getCocktailsByFirstLetter(letterSearch: String): RequestResult<List<Cocktail>> {
        return runCatching {
            apiService.getCocktailsByFirstLetter(letterSearch).data
                ?: throw IllegalStateException("cocktails cannot be loaded")
        }.fold(
            onSuccess = { RequestResult.Success(it) },
            onFailure = { RequestResult.Error(it) }
        )
    }

    override suspend fun getCocktailById(id: String): RequestResult<List<Cocktail>> {
        return runCatching {
            apiService.getCocktailById(cocktailId = id).data
                ?: throw IllegalStateException("Can't download the cocktail by id")
        }.fold(
            onSuccess = { RequestResult.Success(it) },
            onFailure = { RequestResult.Error(it) }
        )
    }
}