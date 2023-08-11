package com.example.coctailcard.ui.ingredients

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.coctailcard.data.network.RequestResult
import com.example.coctailcard.data.network.models.Ingredient
import com.example.coctailcard.data.network.models.IngredientDetailed
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

data class IngredientsListState(
    val isLoading: Boolean = false
)

class IngredientsViewModel(
    private val ingredientsRepository: GetIngredientsRepository
) : ViewModel() {

    private val _ingredients = MutableStateFlow<List<Ingredient>>(emptyList())
    val ingredients = _ingredients.asStateFlow()

    private val _state = MutableStateFlow(IngredientsListState(
        isLoading = false
    ))
    val state = _state.asStateFlow()

    init {
        fetchIngredients()
    }

    private fun fetchIngredients() {
        viewModelScope.launch(Dispatchers.IO) {
            _state.update { it.copy(isLoading = true) }
            delay(5000L)
            when (val result = ingredientsRepository.getIngredientsList()) {
                is RequestResult.Success -> {
                    runCatching {
                        _ingredients.value = result.data
                        Log.d("IngredientsReq", "${result.data}")
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