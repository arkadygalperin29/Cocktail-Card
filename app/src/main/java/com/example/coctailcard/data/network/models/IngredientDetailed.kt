package com.example.coctailcard.data.network.models

import com.google.gson.annotations.SerializedName

open class IngredientDetailed(
    @SerializedName("idIngredient")
    var id: String? = null,
    @SerializedName("strIngredient")
    var name: String? = null,
    @SerializedName("strDescription")
    var description: String? = null,
    @SerializedName("strType")
    var drinkType: String? = null,
    @SerializedName("strAlcohol")
    var isAlcoholic: String? = null,
    @SerializedName("strABV")
    var alcoholicVolume: String? = null
)
