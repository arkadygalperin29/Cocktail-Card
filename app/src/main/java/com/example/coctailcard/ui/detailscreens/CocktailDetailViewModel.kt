package com.example.coctailcard.ui.detailscreens

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.coctailcard.data.network.RequestResult
import com.example.coctailcard.data.network.models.Cocktail
import com.example.coctailcard.data.network.models.IngredientDetailed
import com.example.coctailcard.data.repositories.GetCocktailsRepository
import com.example.coctailcard.data.repositories.ingredients.GetIngredientsRepository
import com.example.coctailcard.util.UiEvent
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
data class CocktailDetailState(
    val isLoading: Boolean = false
)

class CocktailDetailViewModel(
    private val getCocktailsRepository: GetCocktailsRepository,
    private val ingredientsRepository: GetIngredientsRepository
) : ViewModel() {

    private val _uiEvent = Channel<UiEvent>()
    val uiEvent = _uiEvent.receiveAsFlow()

    private var _cocktail = MutableStateFlow<Cocktail?>(null)
    val cocktail = _cocktail.asStateFlow()

    private var _ingredient = MutableStateFlow<List<IngredientDetailed>>(emptyList())
    val ingredient = _ingredient.asStateFlow()

    private val _state = MutableStateFlow(CocktailDetailState(isLoading = false))
    val state = _state.asStateFlow()
    

    fun getCocktailById(id: String) {
        viewModelScope.launch(Dispatchers.IO) {
            _state.update { it.copy(isLoading = true) }
            when (val response = getCocktailsRepository.getCocktailById(id)) {
                is RequestResult.Success -> {
                    runCatching {
                        _cocktail.value = response.data[0]
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
