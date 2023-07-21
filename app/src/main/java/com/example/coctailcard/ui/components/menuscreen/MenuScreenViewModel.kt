package com.example.coctailcard.ui.components.menuscreen

import androidx.lifecycle.ViewModel
import com.example.coctailcard.data.network.RequestResult
import com.example.coctailcard.data.network.models.Cocktail
import com.example.coctailcard.data.repositories.GetCocktailsRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class MenuScreenViewModel(
    val getCocktailsRepository: GetCocktailsRepository
) : ViewModel() {

    private val _cocktails = MutableStateFlow<List<Cocktail>>(emptyList())
    val cocktails = _cocktails.asStateFlow()

    suspend fun fetchCocktails() {
        when (val response = getCocktailsRepository.getCocktailsByFirstLetter()) {
            is RequestResult.Success -> {
                runCatching {
                   _cocktails.emit(cocktails.value)
                }.onFailure {
                    it.printStackTrace()
                }
            }
            else -> {
            }
        }
    }

}