package com.example.coctailcard.ui.ingredients

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.coctailcard.ui.components.CoctailScaffold
import com.example.coctailcard.ui.theme.Pink40

@Composable
fun IngredientsScreen(
    modifier: Modifier = Modifier,
    navController: NavController = rememberNavController()
) {
    CoctailScaffold(
        modifier = modifier,
        navController = navController,
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Pink40)
                .padding(paddingValues),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

        }
    }
}

@Preview
@Composable
fun IngredientsScreenPreview() {
    IngredientsScreen()
}