package com.example.coctailcard.data.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class TableUpdateTimestamp(
    @PrimaryKey
    var id: String = "",

    @ColumnInfo(defaultValue = "0")
    var timestamp: Long = 0L
)