package com.example.coctailcard.ui.components.scaffold

import androidx.annotation.DrawableRes
import androidx.compose.ui.Alignment
import com.example.coctailcard.R

sealed class AppHeaderType {
    data class WithLogo(
        val logoAlignment: Alignment.Horizontal = Alignment.CenterHorizontally
    ) : AppHeaderType()

    data class WithLogoWithoutFavorites(
        val logoAlignment: Alignment.Horizontal = Alignment.CenterHorizontally
    ) : AppHeaderType()

    data class WithButtons(
        val title: String? = null,
        val onRetrunClick: () -> Unit,
        @DrawableRes val returnIconResId: Int = R.drawable.baseline_chevron_left_24
    ) : AppHeaderType()

    object None : AppHeaderType()
}