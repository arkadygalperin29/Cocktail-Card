package com.example.coctailcard.data.network

import com.example.coctailcard.data.network.models.AlcoholicCocktail
import com.example.coctailcard.data.network.models.Cocktail
import com.example.coctailcard.data.network.models.NonAlcoholicCocktail
import com.example.coctailcard.data.network.models.SampleData
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET("sampleData")
    suspend fun getSampleData(): List<SampleData>

    @GET("search.php?f=a")
    suspend fun getCocktailsByFirstLetter(): ApiResponse<List<Cocktail>>
    //list all cocktails by first letter www.thecocktaildb.com/api/json/v1/1/search.php?f=a
    @GET("filter.php?a=Alcoholic")
    suspend fun getCocktailsWithAlcohol(): ApiResponse<List<AlcoholicCocktail>>
    @GET("filter.php?a=Non_Alcoholic")
    suspend fun getNonAlcoholicCocktails(): ApiResponse<List<NonAlcoholicCocktail>>
}