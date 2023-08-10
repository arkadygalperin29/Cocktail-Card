package com.example.coctailcard.data.network

import com.example.coctailcard.data.network.models.Cocktail
import com.example.coctailcard.data.network.models.Glass
import com.example.coctailcard.data.network.models.ImageLoad
import com.example.coctailcard.data.network.models.Ingredient
import com.example.coctailcard.data.network.models.IngredientDetailed
import com.example.coctailcard.data.network.models.SampleData
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {
    @GET("sampleData")
    suspend fun getSampleData(): List<SampleData>

    @GET("search.php")
    suspend fun getCocktailsByFirstLetter(@Query("f") letterSearch: String): ApiResponse<List<Cocktail>>

    @GET("search.php")
    suspend fun getIngredientByIngredientsName(@Query("i") ingredientNameSearch: String): IngredientsResponse<List<IngredientDetailed>>
    @GET("www.thecocktaildb.com/images/ingredients/{imageName}")
    fun getIngredientImageByName(@Path("imageName") imageName: String): ImageLoad

    @GET("lookup.php")
    suspend fun getIngredientBySearch(@Query("iid") searchQuery: String): IngredientsResponse<List<IngredientDetailed>>

    //list all cocktails by first letter www.thecocktaildb.com/api/json/v1/1/search.php?f=a
    @GET("filter.php?a=Alcoholic")
    suspend fun getCocktailsWithAlcohol(): ApiResponse<List<Cocktail>>

    @GET("filter.php?a=Non_Alcoholic")
    suspend fun getNonAlcoholicCocktails(): ApiResponse<List<Cocktail>>

    @GET("lookup.php")
    suspend fun getCocktailById(@Query("i") cocktailId: String): ApiResponse<List<Cocktail>>

    @GET("list.php?g=list")
    suspend fun getAllKindsOfGlasses(): ApiResponse<List<Glass>>

    @GET("list.php?i=list")
    suspend fun getIngredientsList(): ApiResponse<List<Ingredient>>

    @GET("lookup.php")
    suspend fun getIngredientById(@Query("iid") ingredientId: String): IngredientsResponse<List<IngredientDetailed>>
}