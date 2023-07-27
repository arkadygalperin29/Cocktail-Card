package com.example.coctailcard.ui.detailscreens

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.coctailcard.data.network.RequestResult
import com.example.coctailcard.data.network.models.Cocktail
import com.example.coctailcard.data.repositories.GetCocktailsRepository
import com.example.coctailcard.ui.category.CategoriesSelection
import com.example.coctailcard.util.UiEvent
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch

class CocktailDetailViewModel(
    private val getCocktailsRepository: GetCocktailsRepository
) : ViewModel() {

    private val _uiEvent = Channel<UiEvent>()
    val uiEvent = _uiEvent.receiveAsFlow()

    private var _cocktail = MutableStateFlow<Cocktail?>(null)
    val cocktail = _cocktail.asStateFlow()

    fun getCocktailById(id: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            when (val response = getCocktailsRepository.getCocktailById(id)) {
                is RequestResult.Success -> {
                    runCatching {
                        _cocktail.value = response.data
                    }.onFailure {
                        it.printStackTrace()
                    }
                }

                else -> {
                    sendUiEvent(UiEvent.NavigateTo { navigateToCategory(CategoriesSelection.NON_ALCOHOLIC) })
                }
            }
        }
    }

    private suspend fun sendUiEvent(event: UiEvent) {
        _uiEvent.send(event)
    }
}
