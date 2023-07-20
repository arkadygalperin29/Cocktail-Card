package com.example.coctailcard.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController

@Composable
fun CoctailApp() {
    val navController = rememberNavController()
    CoctailNavGraph(navController = navController)
}