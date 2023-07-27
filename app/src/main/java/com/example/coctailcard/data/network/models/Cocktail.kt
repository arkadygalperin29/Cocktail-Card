package com.example.coctailcard.data.network.models

import com.google.gson.annotations.SerializedName

data class Cocktail(
    @SerializedName("idDrink")
    val id: String,
    @SerializedName("strDrink")
    val name: String?,
    @SerializedName("strCategory")
    val category: String?,
    @SerializedName("strAlcoholic")
    val alcoholic: String?,
    @SerializedName("strGlass")
    val glass: String?,
    @SerializedName("strInstructions")
    val instructions: String?,
    @SerializedName("strDrinkThumb")
    val drinkImage: String?,
    @SerializedName("strIngredient1")
    val strIngredient1: String?,
    @SerializedName("strIngredient2")
    val strIngredient2: String?,
    @SerializedName("strIngredient3")
    val strIngredient3: String?,
    @SerializedName("strIngredient4")
    val strIngredient4: String?,
    @SerializedName("strIngredient5")
    val strIngredient5: String?,
    @SerializedName("strIngredient6")
    val strIngredient6: String?,
    @SerializedName("strIngredient7")
    val strIngredient7: String?,
    @SerializedName("strIngredient8")
    val strIngredient8: String?,
    @SerializedName("strIngredient9")
    val strIngredient9: String?,
    @SerializedName("strIngredient10")
    val strIngredient10: String?,
    @SerializedName("strIngredient11")
    val strIngredient11: String?,
    @SerializedName("strIngredient12")
    val strIngredient12: String?,
    @SerializedName("strIngredient13")
    val strIngredient13: String?,
    @SerializedName("strIngredient14")
    val strIngredient14: String?
)
