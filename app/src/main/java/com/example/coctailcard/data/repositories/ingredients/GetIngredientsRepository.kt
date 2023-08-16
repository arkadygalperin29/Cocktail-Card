package com.example.coctailcard.data.repositories.ingredients

import com.example.coctailcard.data.network.RequestResult
import com.example.coctailcard.domain.models.Ingredient
import com.example.coctailcard.domain.models.IngredientDetailed

interface GetIngredientsRepository {
    suspend fun getIngredientsList(): RequestResult<List<Ingredient>>
    suspend fun getIngredientById(id: String): RequestResult<List<IngredientDetailed>>
    suspend fun getIngredientBySearch(searchQuery: String): RequestResult<List<IngredientDetailed>>
    suspend fun getIngredientByName(searchName: String): RequestResult<List<IngredientDetailed>>
}