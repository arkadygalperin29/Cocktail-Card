package com.example.coctailcard.util

import com.example.coctailcard.navigation.CocktailNavActions


sealed interface MapUnifiedUiEvent

interface ToastType

sealed class UiEvent : MapUnifiedUiEvent {
    data class NavigateTo(val navAction: CocktailNavActions.() -> Unit) : UiEvent()
    data class ShowToast(val toastType: ToastType) : UiEvent()
}