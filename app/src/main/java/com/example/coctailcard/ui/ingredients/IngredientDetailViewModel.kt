package com.example.coctailcard.ui.ingredients

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.network.RequestResult
import com.example.coctailcard.data.repositories.ingredients.GetIngredientsRepository
import com.example.domain.state.ApplicationState
import com.example.coctailcard.util.UiEvent
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch


class IngredientDetailViewModel(
    private val ingredientsRepository: GetIngredientsRepository
) : ViewModel() {

    private val _uiEvent = Channel<UiEvent>()
    val uiEvent = _uiEvent.receiveAsFlow()

    private val _state = MutableStateFlow(
        ApplicationState(
            isLoading = false,
            ingredient = null
        )
    )
    val state = _state.asStateFlow()

    fun fetchIngredientByName(name: String) {
        viewModelScope.launch(Dispatchers.IO) {
            _state.update { it.copy(isLoading = true) }
            when (val result = ingredientsRepository.getIngredientByName(name)) {
                is RequestResult.Success -> {
                    runCatching {
                        _state.update { it.copy(ingredient = result.data[0]) }
                    }.onFailure {
                        it.printStackTrace()
                    }
                }

                else -> {}
            }
            _state.update { it.copy(isLoading = false) }
        }
    }
}