package com.example.coctailcard.data.network.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity
data class SampleData(
    @PrimaryKey
    @SerializedName("id")
    val uid: Int,

    @SerializedName("ping")
    val ping: String? = null,

    @SerializedName("pong")
    @ColumnInfo(name = "my_pong")
    val pong: String? = null,
)