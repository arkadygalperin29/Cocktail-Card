package com.example.coctailcard.ui.category

import androidx.lifecycle.ViewModel
import com.example.coctailcard.data.network.RequestResult
import com.example.coctailcard.data.network.models.AlcoholicCocktail
import com.example.coctailcard.data.network.models.NonAlcoholicCocktail
import com.example.coctailcard.data.repositories.alcoholic.AlcoholicCocktailsRepository
import com.example.coctailcard.data.repositories.nonalcoholic.NonAlcoholicCocktailsRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

data class CategoryState(
    val selectedButton: Int = 0,
    val isError: Boolean = false
)

class CategoryViewModel(
    private val alcoholicCocktailsRepository: AlcoholicCocktailsRepository,
    private val nonAlcoholicCocktailsRepository: NonAlcoholicCocktailsRepository,
    private val page: Int
) :
    ViewModel() {

    private val _state = MutableStateFlow(
        CategoryState(
            selectedButton = page
        )
    )
    val state = _state.asStateFlow()

    private val _alcoholicDrinks = MutableStateFlow<List<AlcoholicCocktail>>(emptyList())
    val alcoholicCocktails = _alcoholicDrinks.asStateFlow()

    private val _nonAlcoholicDrinks = MutableStateFlow<List<NonAlcoholicCocktail>>(emptyList())
    val nonAlcoholicCocktails = _nonAlcoholicDrinks.asStateFlow()

    fun updateState(state: CategoryState) {
        _state.update { state }
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