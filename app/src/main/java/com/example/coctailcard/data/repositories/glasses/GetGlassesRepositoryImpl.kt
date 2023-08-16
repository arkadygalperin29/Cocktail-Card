package com.example.coctailcard.data.repositories.glasses

import com.example.coctailcard.data.network.ApiService
import com.example.coctailcard.data.network.RequestResult
import com.example.coctailcard.domain.models.Glass

class GetGlassesRepositoryImpl(private val apiService: ApiService) : GetGlassesRepository {
    override suspend fun getGlassesList(): RequestResult<List<Glass>> {
        return runCatching {
            apiService.getAllKindsOfGlasses().data
                ?: throw IllegalStateException("Can't download list of glasses")
        }.fold(
            onSuccess = { RequestResult.Success(it) },
            onFailure = { RequestResult.Error(it) }
        )
    }
}