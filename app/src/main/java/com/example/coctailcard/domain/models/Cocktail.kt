package com.example.coctailcard.domain.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity
class CocktailMain : Cocktail()

@Entity
open class Cocktail(
    @PrimaryKey
    @SerializedName("idDrink")
    var id: String = "1",
    @SerializedName("strDrink")
    var name: String? = null,
    @SerializedName("strCategory")
    var category: String? = null,
    @SerializedName("strAlcoholic")
    var alcoholic: String? = null,
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
    var strIngredient14: String? = null
)
