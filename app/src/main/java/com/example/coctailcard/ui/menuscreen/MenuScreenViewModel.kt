package com.example.coctailcard.ui.menuscreen

import androidx.lifecycle.ViewModel
import com.example.coctailcard.data.db.dao.CocktailDao
import com.example.coctailcard.data.repositories.GetCocktailsRepository
import com.example.domain.Cocktail
import com.example.domain.state.ApplicationState
import com.example.network.RequestResult
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update


class MenuScreenViewModel(
    private val getCocktailsRepository: GetCocktailsRepository,
    private val favoriteCocktailsDao: CocktailDao
) : ViewModel() {

    private val _state = MutableStateFlow(
        ApplicationState(
            isLoading = false, searchQuery = "a", cocktails = emptyList()
        )
    )
    val state = _state.asStateFlow()

    private val _cocktails = MutableStateFlow<List<Cocktail>>(emptyList())
    val cocktail = _cocktails.asStateFlow()

    fun setSearchQuery(query: String) {
        _state.update {
            it.copy(searchQuery = query)
        }
    }

    suspend fun fetchCocktails(getLetter: String) {
        _state.update { it.copy(isLoading = true) }
        when (val result = getCocktailsRepository.getCocktailsByFirstLetter(getLetter)) {
            is RequestResult.Success -> {
                _cocktails.value = favoriteCocktailsDao.fetchAll()
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
        _cocktails.value = favoriteCocktailsDao.fetchAll()
//        _state.update { it.copy(cocktails = favoriteCocktailsDao.fetchAll()) }
        _state.update { it.copy(isLoading = false) }
    }
}