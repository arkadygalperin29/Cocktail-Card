package com.example.coctailcard.ui.favorites

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.coctailcard.data.repositories.favorites.FavoriteRepository
import com.example.coctailcard.domain.models.Cocktail
import com.example.coctailcard.domain.models.CocktailMain
import com.example.coctailcard.domain.state.ApplicationState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class FavoritesViewModel(private val favoritesRepository: FavoriteRepository) : ViewModel() {

    private val _state = MutableStateFlow(
        ApplicationState(
            cocktail = Cocktail(),
            favoriteCocktails = emptyList()
        )
    )
    val state = _state.asStateFlow()

    init {
        viewModelScope.launch(Dispatchers.IO) {
            loadFavoriteCocktails()
        }
    }

    private fun loadFavoriteCocktails() {
        viewModelScope.launch(Dispatchers.IO) {
            val favoriteCocktails = favoritesRepository.getAllFavoriteDrinks()
            _state.value = _state.value.copy(favoriteCocktails = favoriteCocktails)
        }
    }

    fun deleteFavorite(favoriteCocktail: Cocktail) {
        viewModelScope.launch(Dispatchers.IO) {
            favoritesRepository.deleteFavoriteDrink(favoriteCocktail)
            loadFavoriteCocktails()
        }
    }

    fun insertFavorite(favoriteCocktail: CocktailMain) {
        viewModelScope.launch {
            favoritesRepository.saveFavoriteDrink(favoriteCocktail)
            loadFavoriteCocktails()
        }
    }
}