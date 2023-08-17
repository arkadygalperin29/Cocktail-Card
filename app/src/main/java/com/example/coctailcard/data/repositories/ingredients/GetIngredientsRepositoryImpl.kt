package com.example.coctailcard.data.repositories.ingredients

import com.example.network.ApiService
import com.example.network.RequestResult
import com.example.domain.Ingredient
import com.example.domain.IngredientDetailed

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

    override suspend fun getIngredientById(id: String): RequestResult<List<IngredientDetailed>> {
        return runCatching {
            apiService.getIngredientById(id).data
                ?: throw IllegalStateException("can't load the ingredient by Id")
        }.fold(
            onSuccess = { RequestResult.Success(it) },
            onFailure = { RequestResult.Error(it) }
        )
    }

    override suspend fun getIngredientBySearch(searchQuery: String): RequestResult<List<IngredientDetailed>> {
        return runCatching {
            apiService.getIngredientBySearch(searchQuery).data
                ?: throw IllegalStateException("can't load the ingredient by query")
        }.fold(
            onSuccess = { RequestResult.Success(it) },
            onFailure = { RequestResult.Error(it) }
        )
    }

    override suspend fun getIngredientByName(searchName: String): RequestResult<List<IngredientDetailed>> {
        return runCatching {
            apiService.getIngredientByIngredientsName(searchName).data
                ?: throw java.lang.IllegalStateException("can't load the ingredient by query")
        }.fold(
            onSuccess = { RequestResult.Success(it) },
            onFailure = { RequestResult.Error(it) }
        )
    }
}