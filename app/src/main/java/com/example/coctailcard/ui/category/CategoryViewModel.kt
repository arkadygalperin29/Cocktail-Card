package com.example.coctailcard.ui.category

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.network.RequestResult
import com.example.coctailcard.data.repositories.alcoholic.AlcoholicCocktailsRepository
import com.example.coctailcard.data.repositories.nonalcoholic.NonAlcoholicCocktailsRepository
import com.example.domain.state.ApplicationState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch


class CategoryViewModel(
    private val alcoholicCocktailsRepository: AlcoholicCocktailsRepository,
    private val nonAlcoholicCocktailsRepository: NonAlcoholicCocktailsRepository,
) : ViewModel() {

    private val _state = MutableStateFlow(
        com.example.domain.state.ApplicationState(
            selectedButton = 1,
            isLoading = false,
            alcoholicCocktails = emptyList(),
            nonAlcoholicCocktails = emptyList()
        )
    )
    val state = _state.asStateFlow()

    fun updateState(state: com.example.domain.state.ApplicationState) {
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


    private suspend fun fetchAlcoholicDrinks() {
        when (val response = alcoholicCocktailsRepository.getAlcoholicCoctails()) {
            is RequestResult.Success -> {
                runCatching {
                    _state.update { it.copy(alcoholicCocktails = response.data) }
                }.onFailure {
                    it.printStackTrace()
                }
            }

            else -> {
            }
        }
    }

    private suspend fun fetchNonAlcoholicDrinks() {
        when (val response = nonAlcoholicCocktailsRepository.getNonAlcoholicCocktails()) {
            is RequestResult.Success -> {
                runCatching {
                    _state.update { it.copy(nonAlcoholicCocktails = response.data) }
                }.onFailure {
                    it.printStackTrace()
                }
            }

            else -> {}
        }
    }
}