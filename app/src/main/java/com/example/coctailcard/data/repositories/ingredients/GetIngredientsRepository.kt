package com.example.coctailcard.data.repositories.ingredients

import com.example.coctailcard.data.network.RequestResult
import com.example.coctailcard.data.network.models.Ingredient

interface GetIngredientsRepository {
    suspend fun getIngredientsList(): RequestResult<List<Ingredient>>
}