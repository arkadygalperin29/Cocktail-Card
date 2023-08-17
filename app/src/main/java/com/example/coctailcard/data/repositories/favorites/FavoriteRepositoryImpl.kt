package com.example.coctailcard.data.repositories.favorites

import com.example.coctailcard.data.db.dao.CocktailDao
import com.example.coctailcard.domain.models.Cocktail

class FavoriteRepositoryImpl(private val cocktailDao: CocktailDao) : FavoriteRepository {
    override fun getAllFavoriteDrinks(): List<Cocktail> {
        return cocktailDao.getAllCocktails()
    }

    override suspend fun saveFavoriteDrink(cocktailMain: Cocktail) {
        cocktailDao.addFavoriteCocktail(cocktailMain)
    }

    override suspend fun deleteFavoriteDrink(cocktailMain: Cocktail) {
        cocktailDao.deleteFavoriteCocktail(cocktailMain)
    }
}