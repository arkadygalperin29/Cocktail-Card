package com.example.coctailcard.ui.glassscreen

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.coctailcard.data.network.RequestResult
import com.example.coctailcard.data.network.models.Glass
import com.example.coctailcard.data.repositories.glasses.GetGlassesRepository
import com.example.coctailcard.util.UiEvent
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

data class GlassState(
    val isLoading: Boolean = false
)

class GlassViewModel(private val glassesRepository: GetGlassesRepository) : ViewModel() {

    private val _glasses = MutableStateFlow<List<Glass>>(emptyList())
    val glasses = _glasses.asStateFlow()

    private val _glassState = MutableStateFlow(GlassState(isLoading = false))
    val glassState = _glassState.asStateFlow()

    init {
        fetchGlasses()
    }

    private fun fetchGlasses() {
        viewModelScope.launch(Dispatchers.IO) {
            _glassState.update { it.copy(isLoading = true) }
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
            _glassState.update { it.copy(isLoading = false) }
        }
    }
}