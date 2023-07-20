package com.example.coctailcard.util

import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.calculateEndPadding
import androidx.compose.foundation.layout.calculateStartPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.verticalScroll
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.LayoutDirection

fun Modifier.paddingWithScroll(paddingValues: PaddingValues, scrollState: ScrollState) =
    this
        .padding(
            top = paddingValues.calculateTopPadding(),
            start = paddingValues.calculateStartPadding(LayoutDirection.Ltr),
            end = paddingValues.calculateEndPadding(LayoutDirection.Ltr),
        )
        .verticalScroll(scrollState)
        .padding(bottom = paddingValues.calculateBottomPadding())