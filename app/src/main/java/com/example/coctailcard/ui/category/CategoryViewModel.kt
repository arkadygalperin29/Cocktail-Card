package com.example.coctailcard.ui.category

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.coctailcard.data.network.RequestResult
import com.example.coctailcard.data.network.models.AlcoholicCocktail
import com.example.coctailcard.data.network.models.NonAlcoholicCocktail
import com.example.coctailcard.data.repositories.alcoholic.AlcoholicCocktailsRepository
import com.example.coctailcard.data.repositories.nonalcoholic.NonAlcoholicCocktailsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

data class CategoryState(
    val selectedButton: Int = 0,
    val isError: Boolean = false
)

class CategoryViewModel(
    private val alcoholicCocktailsRepository: AlcoholicCocktailsRepository,
    private val nonAlcoholicCocktailsRepository: NonAlcoholicCocktailsRepository,
) : ViewModel() {

    private val _state = MutableStateFlow(
        CategoryState(
            selectedButton = 1
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

    init {
        fetchBothRequests()
    }

    private fun fetchBothRequests() {
        viewModelScope.launch(Dispatchers.IO) {
            fetchAlcoholicDrinks()
            fetchNonAlcoholicDrinks()
        }
    }



    suspend fun fetchAlcoholicDrinks() {
        Log.d("Response", "msg: ${_alcoholicDrinks.value.toString()}")
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