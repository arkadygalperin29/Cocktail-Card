package com.example.domain

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName


@Entity
open class Cocktail(
    @PrimaryKey
    @SerializedName("idDrink")
    var id: String = "-1",
    @SerializedName("strDrink")
    var name: String? = null,
    @SerializedName("strCategory")
    var category: String? = null,
    @SerializedName("strAlcoholic")
    var alcoholic: String? = null,
    @SerializedName("strVideo")
    var videoLink: String? = null,
    @SerializedName("strTags")
    var tags: String? = null,
    @SerializedName("strGlass")
    var glass: String? = null,
    @SerializedName("strInstructions")
    var instructions: String? = null,
    @SerializedName("strDrinkThumb")
    var drinkImage: String? = null,
    @SerializedName("strIngredient1")
    var strIngredient1: String? = null,
    @SerializedName("strIngredient2")
    var strIngredient2: String? = null,
    @SerializedName("strIngredient3")
    var strIngredient3: String? = null,
    @SerializedName("strIngredient4")
    var strIngredient4: String? = null,
    @SerializedName("strIngredient5")
    var strIngredient5: String? = null,
    @SerializedName("strIngredient6")
    var strIngredient6: String? = null,
    @SerializedName("strIngredient7")
    var strIngredient7: String? = null,
    @SerializedName("strIngredient8")
    var strIngredient8: String? = null,
    @SerializedName("strIngredient9")
    var strIngredient9: String? = null,
    @SerializedName("strIngredient10")
    var strIngredient10: String? = null,
    @SerializedName("strIngredient11")
    var strIngredient11: String? = null,
    @SerializedName("strIngredient12")
    var strIngredient12: String? = null,
    @SerializedName("strIngredient13")
    var strIngredient13: String? = null,
    @SerializedName("strIngredient14")
    var strIngredient14: String? = null,
    @SerializedName("strIngredient15")
    var strIngredient15: String? = null,
    @SerializedName("strMeasure1")
    var strMeasure1: String? = null,
    @SerializedName("strMeasure2")
    var strMeasure2: String? = null,
    @SerializedName("strMeasure3")
    var strMeasure3: String? = null,
    @SerializedName("strMeasure4")
    var strMeasure4: String? = null,
    @SerializedName("strMeasure5")
    var strMeasure5: String? = null,
    @SerializedName("strMeasure6")
    var strMeasure6: String? = null,
    @SerializedName("strMeasure7")
    var strMeasure7: String? = null,
    @SerializedName("strMeasure8")
    var strMeasure8: String? = null,
    @SerializedName("strMeasure9")
    var strMeasure9: String? = null,
    @SerializedName("strMeasure10")
    var strMeasure10: String? = null,
    @SerializedName("strMeasure11")
    var strMeasure11: String? = null,
    @SerializedName("strMeasure12")
    var strMeasure12: String? = null,
    @SerializedName("strMeasure13")
    var strMeasure13: String? = null,
    @SerializedName("strMeasure14")
    var strMeasure14: String? = null,
    @SerializedName("strMeasure15")
    var strMeasure15: String? = null,
)
