package com.example.coctailcard.data.db.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.coctailcard.data.db.BaseDao
import com.example.coctailcard.domain.models.Cocktail
import com.example.coctailcard.domain.models.CocktailMain
import kotlinx.coroutines.flow.Flow

@Dao
abstract class CocktailDao: BaseDao<Cocktail>() {
    override val tableName: String
        get() = "CocktailMain"

    @Query("SELECT * FROM cocktail WHERE id is not null")
    abstract fun getAllCocktails(): Flow<List<Cocktail>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract suspend fun addFavoriteCocktail(cocktailMain: Cocktail)

    @Delete
    abstract suspend fun deleteFavoriteCocktail(cocktailMain: Cocktail)

}