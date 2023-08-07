package com.example.coctailcard.data.network.models

import com.google.gson.annotations.SerializedName

open class IngredientDetailed(
    @SerializedName("idIngredient")
    var id: String,
    @SerializedName("strIngredient")
    var name: String,
    @SerializedName("strDescription")
    var description: String,
    @SerializedName("strType")
    var glassType: String,
    @SerializedName("strAlcohol")
    var isAlcoholic: String,
    @SerializedName("strABV")
    var alcoholicVolume: String? = null
)
