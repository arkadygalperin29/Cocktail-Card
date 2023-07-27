package com.example.coctailcard.navigation

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navigation
import com.example.coctailcard.ui.category.CategoryScreen
import com.example.coctailcard.ui.category.CategoryViewModel
import com.example.coctailcard.ui.glassscreen.GlassScreen
import com.example.coctailcard.ui.menuscreen.MenuScreen
import org.koin.androidx.compose.koinViewModel
import org.koin.core.parameter.parametersOf

@Composable
fun CoctailNavGraph(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
) {
    NavHost(
        navController = navController,
        startDestination = CoctailDestinations.MAIN_GRAPH,
        modifier = modifier
    ) {
        authGraph(navController)
        mainGraph(navController)
    }
}

fun NavGraphBuilder.authGraph(navController: NavHostController) {
    navigation(
        route = CoctailDestinations.MAIN_GRAPH,
        startDestination = CoctailDestinations.MENU_ROUTE
    ) {
        composable(CoctailDestinations.MENU_ROUTE) {
            MenuScreen(
                navController = navController
            )
        }
    }
}

fun NavGraphBuilder.mainGraph(navController: NavHostController) {
    navigation(
        route = CoctailDestinations.MAIN_GRAPH,
        startDestination = CoctailDestinations.MENU_ROUTE
    ) {
        composable(CoctailDestinations.MENU_ROUTE) {
            MenuScreen(
                navController = navController,
            )
        }
        composable(CoctailDestinations.GLASS_ROUTE) {
            GlassScreen()
        }
        composable(CoctailDestinations.CATEGORY_ROUTE) {
            val viewModel: CategoryViewModel = koinViewModel()
            CategoryScreen(
                navController = navController,
                viewModel = viewModel
            )
        }
    }
}