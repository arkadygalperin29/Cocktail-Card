package com.example.coctailcard.ui.favorites

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.coctailcard.data.repositories.favorites.FavoriteRepository
import com.example.coctailcard.domain.models.CocktailMain
import com.example.coctailcard.domain.state.ApplicationState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class FavoritesViewModel(private val favoritesRepository: FavoriteRepository) : ViewModel() {

    private val _state = MutableStateFlow(
        ApplicationState(
            favoriteCocktails = emptyList()
        )
    )
    val state = _state.asStateFlow()

    fun deleteFavorite(favoriteCocktail: CocktailMain) {
        viewModelScope.launch {
            favoritesRepository.deleteFavoriteDrink(favoriteCocktail)
        }
    }

    fun insertFavorite(favoriteCocktail: CocktailMain) {
        viewModelScope.launch {
            favoritesRepository.saveFavoriteDrink(favoriteCocktail)
        }
    }
}