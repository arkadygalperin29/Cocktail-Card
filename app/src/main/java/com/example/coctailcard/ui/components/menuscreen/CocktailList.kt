package com.example.coctailcard.ui.components.menuscreen

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import org.koin.androidx.compose.koinViewModel

@Composable
fun InitialCocktailList(
    navController: NavController,
    viewModel: MenuScreenViewModel = koinViewModel(),
    paddingValues: PaddingValues = PaddingValues()
) {

}

@Preview
@Composable
fun InitialCocktailListPreview() {
InitialCocktailList(navController = rememberNavController())
}