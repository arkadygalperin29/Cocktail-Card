package com.example.coctailcard.domain.models

import androidx.annotation.DrawableRes
import com.google.gson.annotations.SerializedName

data class Ingredient(
    @SerializedName("strIngredient1")
    val ingredientName: String,
    @DrawableRes
    val image: Int? = null,
    val description: String? = null
)
