package com.example.network

import com.google.gson.annotations.SerializedName

data class ApiResponse<T : Any>(
    @SerializedName("drinks")
    val data: T?
)
