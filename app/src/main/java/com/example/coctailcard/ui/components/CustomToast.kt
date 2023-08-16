package com.example.coctailcard.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun CustomPopup(
    title: String,
    contentColor: String
) {
    Column(modifier = Modifier.fillMaxSize()) {

    }

}

@Preview
@Composable
fun CustomPopupPreview() {
    CustomPopup("fasf", "fsafas")
}