package com.example.coctailcard

import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.example.coctailcard.navigation.CoctailNavGraph
import com.example.coctailcard.ui.theme.CocktailCardTheme

@Composable
fun CoctailCardApp() {
    CocktailCardTheme {
        val navController = rememberNavController()
        CoctailNavGraph(navController = navController)
    }
}