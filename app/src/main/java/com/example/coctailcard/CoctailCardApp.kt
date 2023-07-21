package com.example.coctailcard

import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.example.coctailcard.navigation.CoctailNavGraph
import com.example.coctailcard.ui.theme.CoctailCardTheme

@Composable
fun CoctailCardApp() {
    CoctailCardTheme {
        val navController = rememberNavController()
        CoctailNavGraph(navController = navController)
    }
}