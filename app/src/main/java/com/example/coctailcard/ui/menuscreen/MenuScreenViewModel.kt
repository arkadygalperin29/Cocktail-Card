package com.example.coctailcard.ui.menuscreen

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.coctailcard.data.network.RequestResult
import com.example.coctailcard.data.network.models.Cocktail
import com.example.coctailcard.data.repositories.GetCocktailsRepository
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

data class MenuState(
    val isLoading: Boolean = false
)

class MenuScreenViewModel(
    private val getCocktailsRepository: GetCocktailsRepository
) : ViewModel() {


    private val _cocktails = MutableStateFlow<List<Cocktail>>(emptyList())
    val cocktails = _cocktails.asStateFlow()

    private val _searchQuery = MutableStateFlow("a")
    val searchQuery = _searchQuery.asStateFlow()

    private val _state = MutableStateFlow(MenuState(isLoading = false))
    val state = _state.asStateFlow()

    fun setSearchQuery(query: String) {
        _searchQuery.value = query
    }

    suspend fun fetchCocktails(getLetter: String) {
        _state.update { it.copy(isLoading = true) }
        when (val result = getCocktailsRepository.getCocktailsByFirstLetter(getLetter)) {
            is RequestResult.Success -> {
                runCatching {
                    _cocktails.value = result.data
                    Log.d("CocktailReq", "${result.data}")
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