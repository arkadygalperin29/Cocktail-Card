package com.example.coctailcard.data.repositories.glasses

import com.example.network.RequestResult
import com.example.domain.Glass

interface GetGlassesRepository {
    suspend fun getGlassesList(): RequestResult<List<Glass>>
}