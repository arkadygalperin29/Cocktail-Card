package com.example.coctailcard.data.db

import androidx.room.Dao
import androidx.room.Query
import com.example.coctailcard.data.models.TableUpdateTimestamp

@Dao
abstract class TableUpdateTimestampDao : BaseDao<TableUpdateTimestamp>() {
    override val tableName: String
        get() = "tableupdatetimestamp"

    @Query("SELECT * FROM tableupdatetimestamp WHERE id = :id")
    abstract suspend fun fetchId(id: String): TableUpdateTimestamp?
}