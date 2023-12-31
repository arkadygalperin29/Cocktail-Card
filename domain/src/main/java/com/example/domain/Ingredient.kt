package com.example.domain

import androidx.annotation.DrawableRes
import com.google.gson.annotations.SerializedName

data class Ingredient(
    @SerializedName("strIngredient1")
    val ingredientName: String,
    @DrawableRes
    val image: Int? = null,
    val description: String? = null
)
