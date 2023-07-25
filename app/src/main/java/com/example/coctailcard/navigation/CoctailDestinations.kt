package com.example.coctailcard.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import com.example.coctailcard.ui.category.CategoriesSelection
import org.koin.core.component.KoinComponent


typealias CoctailRoute = String

object CoctailDestinations {
    const val AUTH_GRAPH = "auth_grapg"
    const val MAIN_GRAPH = "main_grabg"

    const val MENU_ROUTE = "home"
    const val OFFERS_ROUTE: CoctailRoute = "offers/{page}"
    const val GLASS_ROUTE = "glass_route"
    const val ACCOUNT_DATA_ROUTE = "accountdata"
    const val ACCOUNT_PASSWORD_ROUTE = "accountpassword"
    const val COUPON_ROUTE: CoctailRoute = "coupon/{id}"
    const val PROMOTION_ROUTE: CoctailRoute = "promotion/{id}"
    const val STATION_ROUTE: CoctailRoute = "station/{id}"
    const val NON_ALCOHOLIC_ROUTE = "non_alcoholic_route"
    const val ALCOHOLIC_ROUTE = "alcoholic_route"
    const val CATEGORY_ROUTE = "category_route"


    const val ARG_CODE = "code"
    const val ARG_EMAIL = "email"
    const val ARG_ID = "id"
    const val ARG_PAGE = "page"
}

@Composable
fun rememberCoctailNavActions(navController: NavController) = remember(navController) {
    CoctailNavActions(navController)
}

class CoctailNavActions(private val navController: NavController) : KoinComponent {
    val navigateToHome: () -> Unit = {
        navController.popBackStack(
            route = CoctailDestinations.MENU_ROUTE,
            inclusive = false,
            saveState = true,
        )
    }
    val navigateToInbox: () -> Unit = {
        navController.navigate(CoctailDestinations.GLASS_ROUTE) {
            val primaryRoute: Int? = navController.currentBackStackEntry?.destination?.id
            val fallbackRoute: Int = navController.graph.findStartDestination().id
            popUpTo(primaryRoute ?: fallbackRoute) {
                saveState = true
            }
            launchSingleTop = true
            restoreState = true
        }
    }

    val navigateToCategory: (CategoriesSelection) -> Unit = {
        navController.navigate(CoctailDestinations.CATEGORY_ROUTE) {
            val primaryRoute: Int? = navController.currentBackStackEntry?.destination?.id
            val fallbackRoute: Int = navController.graph.findStartDestination().id
            popUpTo(primaryRoute ?: fallbackRoute) {
                saveState = true
            }
            launchSingleTop = true
 //           restoreState = true
        }
    }
}