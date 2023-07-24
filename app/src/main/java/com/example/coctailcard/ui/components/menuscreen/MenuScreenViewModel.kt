package com.example.coctailcard.ui.components.menuscreen

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.coctailcard.data.network.RequestResult
import com.example.coctailcard.data.network.models.Cocktail
import com.example.coctailcard.data.repositories.GetCocktailsRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class MenuScreenViewModel(

) : ViewModel() {


    private val _cocktails = MutableStateFlow<List<Cocktail>>(emptyList())
    val cocktails = _cocktails.asStateFlow()

/*    init {
        viewModelScope.launch {
            fetchCocktails()
        }
    }*/
/*
    suspend fun fetchCocktails() {
        when (val result = getCocktailsRepository.getCocktailsByFirstLetter()) {
            is RequestResult.Success -> {
                runCatching {
                    _cocktails.emit(result.data)
                    Log.d("CocktailReq", "${result.data}")
                }.onFailure {
                    it.printStackTrace()
                }
            }
            else -> {
            }
        }
    }*/

}