package com.example.coctailcard.data.network.models

import com.google.gson.annotations.SerializedName

data class NonAlcoholicCocktail(
    @SerializedName("strDrink")
    val name: String,
    @SerializedName("strDrinkThumb")
    val image: String,
    @SerializedName("idDrink")
    val id: String
)
