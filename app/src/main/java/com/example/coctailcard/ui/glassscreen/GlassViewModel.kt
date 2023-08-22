package com.example.coctailcard.ui.glassscreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.network.RequestResult
import com.example.coctailcard.data.repositories.glasses.GetGlassesRepository
import com.example.domain.state.ApplicationState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch


class GlassViewModel(private val glassesRepository: GetGlassesRepository) : ViewModel() {


    private val _glassState =
        MutableStateFlow(
            ApplicationState(
                isLoading = false,
                glasses = emptyList()
            )
        )
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
                        _glassState.update { it.copy(glasses = result.data) }
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