package com.example.domain

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity
class IngredientMain: IngredientDetailed()

@Entity
open class IngredientDetailed(
    @PrimaryKey
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
