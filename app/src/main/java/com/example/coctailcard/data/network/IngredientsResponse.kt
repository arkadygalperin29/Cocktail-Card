package com.example.coctailcard.data.network

import com.google.gson.annotations.SerializedName

data class IngredientsResponse<T: Any>(
    @SerializedName("ingredients")
    val data: T?
)