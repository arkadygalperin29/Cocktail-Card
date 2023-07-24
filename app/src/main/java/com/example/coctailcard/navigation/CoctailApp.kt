package com.example.coctailcard.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.runtime.getValue
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.coctailcard.ui.theme.CocktailCardTheme

val LocalNavController = compositionLocalOf<NavHostController> {
    throw IllegalStateException()
}

@Composable
fun CoctailApp() {
    CocktailCardTheme {
        val navController = rememberNavController()
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route ?: CoctailDestinations.MENU_ROUTE
        CompositionLocalProvider(LocalNavController provides navController) {
            CoctailNavGraph(navController = navController)
        }
    }
}