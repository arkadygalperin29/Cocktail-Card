package com.example.coctailcard.ui.category

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.coctailcard.data.network.RequestResult
import com.example.coctailcard.data.network.models.Cocktail
import com.example.coctailcard.data.repositories.alcoholic.AlcoholicCocktailsRepository
import com.example.coctailcard.data.repositories.nonalcoholic.NonAlcoholicCocktailsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

data class CategoryState(
    val selectedButton: Int = 0,
    val isLoading: Boolean = false
)

class CategoryViewModel(
    private val alcoholicCocktailsRepository: AlcoholicCocktailsRepository,
    private val nonAlcoholicCocktailsRepository: NonAlcoholicCocktailsRepository,
) : ViewModel() {

    private val _state = MutableStateFlow(
        CategoryState(
            selectedButton = 1,
            isLoading = false
        )
    )
    val state = _state.asStateFlow()

    private val _alcoholicDrinks = MutableStateFlow<List<Cocktail>>(emptyList())
    val alcoholicCocktails = _alcoholicDrinks.asStateFlow()

    private val _nonAlcoholicDrinks = MutableStateFlow<List<Cocktail>>(emptyList())
    val nonAlcoholicCocktails = _nonAlcoholicDrinks.asStateFlow()

    fun updateState(state: CategoryState) {
        _state.update { state }
    }

    init {
        fetchBothRequests()
    }

    private fun fetchBothRequests() {
        viewModelScope.launch(Dispatchers.IO) {
            _state.update { it.copy(isLoading = true) }
            fetchAlcoholicDrinks()
            fetchNonAlcoholicDrinks()
            _state.update { it.copy(isLoading = false) }
        }
    }


    suspend fun fetchAlcoholicDrinks() {
        when (val response = alcoholicCocktailsRepository.getAlcoholicCoctails()) {
            is RequestResult.Success -> {
                runCatching {
                    _alcoholicDrinks.value = response.data
                }.onFailure {
                    it.printStackTrace()
                }
            }
            else -> {
            }
        }
    }

    suspend fun fetchNonAlcoholicDrinks() {
        when (val response = nonAlcoholicCocktailsRepository.getNonAlcoholicCocktails()) {
            is RequestResult.Success -> {
                runCatching {
                    _nonAlcoholicDrinks.value = response.data
                }.onFailure {
                    it.printStackTrace()
                }
            }
            else -> {}
        }
    }
}