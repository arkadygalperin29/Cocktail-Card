package com.example.coctailcard.navigation

import android.os.Bundle
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.core.text.isDigitsOnly
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navDeepLink
import androidx.navigation.navigation
import com.example.coctailcard.ui.category.CategoryScreen
import com.example.coctailcard.ui.category.CategoryViewModel
import com.example.coctailcard.ui.detailscreens.CocktailDetailViewModel
import com.example.coctailcard.ui.detailscreens.PromotionDetailScreen
import com.example.coctailcard.ui.glassscreen.GlassScreen
import com.example.coctailcard.ui.menuscreen.MenuScreen
import com.example.coctailcard.ui.menuscreen.MenuScreenViewModel
import org.koin.androidx.compose.koinViewModel

val Bundle?.idFromDeeplink
    get() = this?.getString(CocktailAppDeeplinks.ARG_ID)
        .takeIf { it?.isNotBlank() ?: false && it?.isDigitsOnly() ?: false }

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
            val viewModel: MenuScreenViewModel = koinViewModel()
            MenuScreen(
                navController = navController,
                viewModel = viewModel
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
        composable(
            route = CoctailDestinations.ALCOHOLIC_ROUTE,
        ) {
            val id = it.arguments.id
            val viewModel: CocktailDetailViewModel = koinViewModel()
            PromotionDetailScreen(
                navController = navController,
                viewModel = viewModel,
                id = id ?: "-1"
            )
        }
        composable(
            route = CoctailDestinations.NON_ALCOHOLIC_ROUTE,
            deepLinks = listOf(
                navDeepLink { uriPattern = CocktailAppDeeplinks.COCKTAIL }
            )
        ) {
            val id = it.arguments.id
            val viewModel: CocktailDetailViewModel = koinViewModel()
            PromotionDetailScreen(
                navController = navController,
                viewModel = viewModel,
                id = id ?: "-1"
            )
        }
    }
}