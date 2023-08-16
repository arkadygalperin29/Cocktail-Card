package com.example.coctailcard.data.db.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.coctailcard.data.db.BaseDao
import com.example.coctailcard.domain.models.CocktailMain
import kotlinx.coroutines.flow.Flow

@Dao
abstract class CocktailDao: BaseDao<CocktailMain>() {
    override val tableName: String
        get() = "CocktailMain"

    @Query("SELECT * FROM cocktailmain")
    abstract fun getAllCocktails(): Flow<List<CocktailMain>>

    @Insert
    abstract suspend fun addFavoriteCocktail(cocktailMain: CocktailMain)

    @Delete
    abstract suspend fun deleteFavoriteCocktail(cocktailMain: CocktailMain)

}