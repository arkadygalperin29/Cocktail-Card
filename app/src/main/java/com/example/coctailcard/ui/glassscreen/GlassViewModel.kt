package com.example.coctailcard.ui.glassscreen

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.coctailcard.data.network.RequestResult
import com.example.coctailcard.data.network.models.Glass
import com.example.coctailcard.data.repositories.glasses.GetGlassesRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class GlassViewModel(private val glassesRepository: GetGlassesRepository) : ViewModel() {

    private val _glasses = MutableStateFlow<List<Glass>>(emptyList())
    val glasses = _glasses.asStateFlow()

    init {
        fetchGlasses()
    }

    private fun fetchGlasses() {
        viewModelScope.launch(Dispatchers.IO) {
            when (val result = glassesRepository.getGlassesList()) {
                is RequestResult.Success -> {
                    runCatching {
                        _glasses.value = result.data
                        Log.d("CocktailReq", "${result.data}")
                    }.onFailure {
                        it.printStackTrace()
                    }
                }
                else -> {
                }
            }
        }
    }
}