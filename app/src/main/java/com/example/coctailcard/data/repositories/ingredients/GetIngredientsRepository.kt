package com.example.coctailcard.data.repositories.ingredients

import com.example.network.RequestResult
import com.example.domain.Ingredient
import com.example.domain.IngredientDetailed

interface GetIngredientsRepository {
    suspend fun getIngredientsList(): RequestResult<List<Ingredient>>
    suspend fun getIngredientById(id: String): RequestResult<List<IngredientDetailed>>
    suspend fun getIngredientBySearch(searchQuery: String): RequestResult<List<IngredientDetailed>>
    suspend fun getIngredientByName(searchName: String): RequestResult<List<IngredientDetailed>>
}