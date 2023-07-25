package com.example.coctailcard.ui.category

import androidx.lifecycle.ViewModel
import com.example.coctailcard.data.repositories.alcoholic.AlcoholicCocktailsRepository
import com.example.coctailcard.data.repositories.nonalcoholic.NonAlcoholicCocktailsRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

data class CategoryState(
    val selectedButton: Int = 0
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

    fun updateState(state: CategoryState) {
        _state.update { state }
    }
}