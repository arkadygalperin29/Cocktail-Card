package com.example.coctailcard.data.network

import com.example.coctailcard.data.network.models.SampleData
import retrofit2.http.GET

interface ApiService {
    @GET("sampleData")
    suspend fun getSampleData(): List<SampleData>

    //list all cocktails by first letter www.thecocktaildb.com/api/json/v1/1/search.php?f=a
}