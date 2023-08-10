package com.example.coctailcard.ui.ingredients

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.coctailcard.data.network.RequestResult
import com.example.coctailcard.data.network.models.IngredientDetailed
import com.example.coctailcard.data.repositories.ingredients.GetIngredientsRepository
import com.example.coctailcard.util.UiEvent
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch

class IngredientDetailViewModel(
    private val ingredientsRepository: GetIngredientsRepository
) : ViewModel() {

    private val _uiEvent = Channel<UiEvent>()
    val uiEvent = _uiEvent.receiveAsFlow()

    private var _ingredient = MutableStateFlow<IngredientDetailed?>(null)
    val ingredient = _ingredient.asStateFlow()

    fun fetchIngredientByName(name: String) {
        viewModelScope.launch(Dispatchers.IO) {
            when (val result = ingredientsRepository.getIngredientByName(name)) {
                is RequestResult.Success -> {
                    runCatching {
                        _ingredient.value = result.data[0]
                    }.onFailure {
                        it.printStackTrace()
                    }
                }

                else -> {}
            }
        }
    }
}