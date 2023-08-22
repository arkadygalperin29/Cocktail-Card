package com.example.coctailcard.ui.menuscreen

import androidx.lifecycle.ViewModel
import com.example.network.RequestResult
import com.example.coctailcard.data.repositories.GetCocktailsRepository
import com.example.domain.state.ApplicationState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update


class MenuScreenViewModel(
    private val getCocktailsRepository: GetCocktailsRepository
) : ViewModel() {

    private val _state = MutableStateFlow(
        ApplicationState(
            isLoading = false, searchQuery = "a", cocktails = emptyList()
        )
    )
    val state = _state.asStateFlow()

    fun setSearchQuery(query: String) {
        _state.update {
            it.copy(searchQuery = query)
        }
    }

    suspend fun fetchCocktails(getLetter: String) {
        _state.update { it.copy(isLoading = true) }
        when (val result = getCocktailsRepository.getCocktailsByFirstLetter(getLetter)) {
            is RequestResult.Success -> {
                runCatching {
                    _state.update {
                        it.copy(cocktails = result.data)
                    }
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