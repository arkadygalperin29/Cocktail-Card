package com.example.coctailcard.data.repositories.glasses

import com.example.coctailcard.data.network.ApiResponse
import com.example.coctailcard.data.network.RequestResult
import com.example.coctailcard.data.network.models.Glass

interface GetGlassesRepository {
    suspend fun getGlassesList(): RequestResult<List<Glass>>
}