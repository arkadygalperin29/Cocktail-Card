package com.example.coctailcard.data.repositories.ingredients

import com.example.coctailcard.data.network.RequestResult
import com.example.coctailcard.data.network.models.Ingredient
import com.example.coctailcard.data.network.models.IngredientDetailed

interface GetIngredientsRepository {
    suspend fun getIngredientsList(): RequestResult<List<Ingredient>>

    suspend fun getIngredientById(id: String): RequestResult<List<IngredientDetailed>>
}