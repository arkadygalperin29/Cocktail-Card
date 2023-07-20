package com.example.coctailcard.data.db.dao

import androidx.room.Dao
import com.example.coctailcard.data.db.BaseDao
import com.example.coctailcard.data.network.models.SampleData

@Dao
abstract class SampleDataDao: BaseDao<SampleData>() {
    override val tableName: String
       get() = "SampleData" // must be name of database table (not class)
}