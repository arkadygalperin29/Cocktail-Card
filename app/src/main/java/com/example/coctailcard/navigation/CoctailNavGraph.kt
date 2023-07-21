package com.example.coctailcard.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navigation
import com.example.coctailcard.ui.components.glassscreen.GlassScreen
import com.example.coctailcard.ui.components.menuscreen.MenuScreen
import com.example.coctailcard.ui.components.menuscreen.MenuScreenViewModel
import org.koin.androidx.compose.koinViewModel

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
        mainGraph(navController)
    }
}

fun NavGraphBuilder.mainGraph(navController: NavHostController) {
    navigation(
        route = CoctailDestinations.MAIN_GRAPH,
        startDestination = CoctailDestinations.MENU_ROUTE
    ) {
        composable(CoctailDestinations.MENU_ROUTE) {
            val viewModel: MenuScreenViewModel = koinViewModel()
            MenuScreen(
                navController = navController,
                viewModel = viewModel
            )
        }
        composable(CoctailDestinations.GLASS_ROUTE) {
            GlassScreen()
        }
    }
}