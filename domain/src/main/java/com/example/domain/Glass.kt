package com.example.domain

import androidx.annotation.DrawableRes
import com.google.gson.annotations.SerializedName

data class Glass(
    @SerializedName("strGlass")
    val name: String,
    @DrawableRes
    val imageRes: Int? = null,
    val description: String? = null
)
