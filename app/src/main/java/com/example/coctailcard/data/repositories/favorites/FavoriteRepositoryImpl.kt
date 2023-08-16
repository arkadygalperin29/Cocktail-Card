package com.example.coctailcard.data.repositories.favorites

import com.example.coctailcard.data.db.dao.CocktailDao
import com.example.coctailcard.domain.models.Cocktail
import com.example.coctailcard.domain.models.CocktailMain
import kotlinx.coroutines.flow.Flow

class FavoriteRepositoryImpl(private val cocktailDao: CocktailDao) : FavoriteRepository {
    override fun getAllFavoriteDrinks(): Flow<List<Cocktail>> {
        return cocktailDao.getAllCocktails()
    }

    override suspend fun saveFavoriteDrink(cocktailMain: Cocktail) {
        cocktailDao.addFavoriteCocktail(cocktailMain)
    }

    override suspend fun deleteFavoriteDrink(cocktailMain: Cocktail) {
        cocktailDao.deleteFavoriteCocktail(cocktailMain)
    }
}