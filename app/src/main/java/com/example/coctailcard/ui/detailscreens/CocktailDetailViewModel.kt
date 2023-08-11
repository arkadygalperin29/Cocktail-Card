package com.example.coctailcard.ui.detailscreens

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.coctailcard.data.network.RequestResult
import com.example.coctailcard.data.network.models.Cocktail
import com.example.coctailcard.data.repositories.GetCocktailsRepository
import com.example.coctailcard.data.repositories.ingredients.GetIngredientsRepository
import com.example.coctailcard.domain.ApplicationState
import com.example.coctailcard.util.UiEvent
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class CocktailDetailViewModel(
    private val getCocktailsRepository: GetCocktailsRepository
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

    private suspend fun sendUiEvent(event: UiEvent) {
        _uiEvent.send(event)
    }
}
