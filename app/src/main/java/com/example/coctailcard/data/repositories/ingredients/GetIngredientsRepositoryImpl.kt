package com.example.coctailcard.data.repositories.ingredients

import com.example.coctailcard.data.network.ApiService
import com.example.coctailcard.data.network.RequestResult
import com.example.coctailcard.data.network.models.Ingredient

class GetIngredientsRepositoryImpl(private val apiService: ApiService) : GetIngredientsRepository {
    override suspend fun getIngredientsList(): RequestResult<List<Ingredient>> {
        return runCatching {
            apiService.getIngredientsList().data
                ?: throw IllegalStateException("can't load the list of ingredients")
        }.fold(
            onSuccess = { RequestResult.Success(it) },
            onFailure = { RequestResult.Error(it) }
        )
    }
}