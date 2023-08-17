package com.example.coctailcard.ui.detailscreens

import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.coctailcard.data.db.dao.CocktailDao
import com.example.coctailcard.data.network.RequestResult
import com.example.coctailcard.data.repositories.GetCocktailsRepository
import com.example.coctailcard.data.repositories.favorites.FavoriteRepository
import com.example.coctailcard.domain.models.Cocktail
import com.example.coctailcard.domain.state.ApplicationState
import com.example.coctailcard.util.ToastType
import com.example.coctailcard.util.UiEvent
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class CocktailDetailViewModel(
    private val getCocktailsRepository: GetCocktailsRepository,
    private val favoritesRepository: FavoriteRepository,
    private val cocktailDao: CocktailDao
) : ViewModel() {

    private val _uiEvent = Channel<UiEvent>()
    val uiEvent = _uiEvent.receiveAsFlow()

    private val _state =
        MutableStateFlow(ApplicationState(isLoading = false, cocktail = Cocktail()))
    val state = _state.asStateFlow()


    fun getCocktailById(id: String) {
        viewModelScope.launch(Dispatchers.IO) {
            _state.update { it.copy(isLoading = true) }
            when (val response = getCocktailsRepository.getCocktailById(id)) {
                is RequestResult.Success -> {
                    runCatching {
                        _state.update {
                            it.copy(cocktail = response.data[0])
                        }
                    }.onFailure {
                        it.printStackTrace()
                    }
                }

                else -> {
                    //  do empty screen if can't load the data || sendUiEvent(UiEvent.NavigateTo { navigateToCategory(CategoriesSelection.NON_ALCOHOLIC) })
                }
            }
            _state.update { it.copy(isLoading = false) }
        }
    }

    fun deleteFavorite(favoriteCocktail: Cocktail) {
        viewModelScope.launch {
            favoritesRepository.deleteFavoriteDrink(favoriteCocktail)
        }
    }

    fun checkIfCocktailIsAdded(favoriteCocktail: Cocktail) {
        viewModelScope.launch {
            val cocktailFromDb = cocktailDao.getCoctailById(favoriteCocktail.id)
            if (cocktailFromDb == null) {
                cocktailDao.addFavoriteCocktail(favoriteCocktail)
                sendUiEvent(
                    UiEvent.ShowToast(IsCocktailSavedInDatabase.COCKTAIL_IS_NOT_SAVED)
                )
                sendUiEvent(UiEvent.NavigateTo(navAction = { navigateToFavorites() }))
            } else {
                sendUiEvent(UiEvent.ShowToast(IsCocktailSavedInDatabase.COCKTAIL_IS_ALREADY_SAVED))
            }
        }
    }

    fun insertFavorite(favoriteCocktail: Cocktail) {
        viewModelScope.launch(Dispatchers.IO) {
            cocktailDao.addFavoriteCocktail(favoriteCocktail)
        }
    }

    private suspend fun sendUiEvent(event: UiEvent) {
        _uiEvent.send(event)
    }
}

enum class IsCocktailSavedInDatabase : ToastType {
    COCKTAIL_IS_NOT_SAVED,
    COCKTAIL_IS_ALREADY_SAVED
}
