package com.example.coctailcard.ui.ingredients

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.coctailcard.data.network.RequestResult
import com.example.coctailcard.data.repositories.ingredients.GetIngredientsRepository
import com.example.coctailcard.domain.state.ApplicationState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch


class IngredientsViewModel(
    private val ingredientsRepository: GetIngredientsRepository
) : ViewModel() {

    private val _state = MutableStateFlow(
        ApplicationState(
            isLoading = false, ingredients = emptyList()
        )
    )
    val state = _state.asStateFlow()

    init {
        fetchIngredients()
    }

    private fun fetchIngredients() {
        viewModelScope.launch(Dispatchers.IO) {
            _state.update { it.copy(isLoading = true) }
            when (val result = ingredientsRepository.getIngredientsList()) {
                is RequestResult.Success -> {
                    runCatching {
                        _state.update { it.copy(ingredients = result.data) }
                    }.onFailure {
                        it.printStackTrace()
                    }
                }

                else -> {
                }
            }
            _state.update { it.copy(isLoading = false) }
        }
    }
}