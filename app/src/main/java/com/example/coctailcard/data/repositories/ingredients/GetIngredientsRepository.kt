package com.example.coctailcard.data.repositories.ingredients

import com.example.coctailcard.data.network.RequestResult
import com.example.coctailcard.data.network.models.ImageLoad
import com.example.coctailcard.data.network.models.Ingredient
import com.example.coctailcard.data.network.models.IngredientDetailed
import retrofit2.Call

interface GetIngredientsRepository {
    suspend fun getIngredientsList(): RequestResult<List<Ingredient>>
    suspend fun getIngredientById(id: String): RequestResult<List<IngredientDetailed>>
    suspend fun getIngredientBySearch(searchQuery: String): RequestResult<List<IngredientDetailed>>
    suspend fun getIngredientByName(searchName: String): RequestResult<List<IngredientDetailed>>
    suspend fun getImageByIngredientName(imageName: String): RequestResult<ImageLoad>
}