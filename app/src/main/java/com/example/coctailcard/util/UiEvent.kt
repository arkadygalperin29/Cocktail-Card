package com.example.coctailcard.util

import com.example.coctailcard.navigation.CocktailNavActions


sealed interface MapUnifiedUiEvent

sealed class UiEvent : MapUnifiedUiEvent {
    data class NavigateTo(val navAction: CocktailNavActions.() -> Unit) : UiEvent()
}