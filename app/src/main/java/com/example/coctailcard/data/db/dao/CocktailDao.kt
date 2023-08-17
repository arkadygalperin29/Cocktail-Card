package com.example.coctailcard.data.db.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.coctailcard.data.db.BaseDao
import com.example.domain.Cocktail

@Dao
abstract class CocktailDao: BaseDao<com.example.domain.Cocktail>() {
    override val tableName: String
        get() = "CocktailMain"

    @Query("SELECT * FROM cocktail WHERE id is not null")
    abstract fun getAllCocktails(): List<com.example.domain.Cocktail>

    @Query("SELECT EXISTS (SELECT 1 FROM cocktail WHERE id = :cocktailId)")
    abstract suspend fun isCocktailIdInDatabase(cocktailId: String): Boolean

    @Query("SELECT * FROM cocktail WHERE id = :id")
    abstract suspend fun getCoctailById(id: String): com.example.domain.Cocktail?
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract suspend fun addFavoriteCocktail(cocktailMain: com.example.domain.Cocktail)

    @Delete
    abstract suspend fun deleteFavoriteCocktail(cocktailMain: com.example.domain.Cocktail)

}