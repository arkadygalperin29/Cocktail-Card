package com.example.coctailcard.data.db.dao

import androidx.room.Dao
import com.example.coctailcard.data.db.BaseDao
import com.example.domain.SampleData

@Dao
abstract class SampleDataDao: BaseDao<com.example.domain.SampleData>() {
    override val tableName: String
       get() = "SampleData" // must be name of database table (not class)
}