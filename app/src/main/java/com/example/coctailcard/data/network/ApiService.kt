package com.example.coctailcard.data.network

import com.example.coctailcard.data.network.models.AlcoholicCocktail
import com.example.coctailcard.data.network.models.Cocktail
import com.example.coctailcard.data.network.models.Glass
import com.example.coctailcard.data.network.models.NonAlcoholicCocktail
import com.example.coctailcard.data.network.models.SampleData
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

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
    @GET("lookup.php/{id}")
    suspend fun getCocktailById(@Path("id") cocktailId: Int): ApiResponse<Cocktail>
    @GET("list.php?g=list")
    suspend fun getAllKindsOfGlasses(): ApiResponse<List<Glass>>

    @GET("filter.php?g=Champagne_flute")
    suspend fun getAllCocktailsWithChampagneFlute(@Query("g") glassType: String = "Champagne_flute")
            : ApiResponse<List<Cocktail>>

    @GET("filter.php?g=Wine_Glass")
    suspend fun getAllCocktailsWithWineGlass(@Query("g") glassType: String = "Wine_Glass")
            : ApiResponse<List<Cocktail>>
}