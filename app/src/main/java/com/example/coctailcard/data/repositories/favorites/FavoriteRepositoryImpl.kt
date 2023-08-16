package com.example.coctailcard.data.repositories.favorites

import com.example.coctailcard.data.db.dao.CocktailDao
import com.example.coctailcard.domain.models.CocktailMain
import kotlinx.coroutines.flow.Flow

class FavoriteRepositoryImpl(private val cocktailDao: CocktailDao) : FavoriteRepository {
    override fun getAllFavoriteDrinks(): Flow<List<CocktailMain>> {
        return cocktailDao.getAllCocktails()
    }

    override suspend fun saveFavoriteDrink(cocktailMain: CocktailMain) {
        cocktailDao.addFavoriteCocktail(cocktailMain)
    }

    override suspend fun deleteFavoriteDrink(cocktailMain: CocktailMain) {
        cocktailDao.deleteFavoriteCocktail(cocktailMain = cocktailMain)
    }
}