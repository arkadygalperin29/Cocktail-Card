package com.example.coctailcard.navigation

import android.os.Bundle
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import com.example.coctailcard.navigation.CoctailDestinations.ARG_GLASS_NAME
import com.example.coctailcard.navigation.CoctailDestinations.ARG_ID
import com.example.coctailcard.navigation.CoctailDestinations.ARG_IID
import com.example.coctailcard.navigation.CoctailDestinations.ARG_PAGE
import com.example.coctailcard.ui.category.CategoriesSelection
import org.koin.core.component.KoinComponent


typealias CocktailRoute = String

object CoctailDestinations {
    const val AUTH_GRAPH = "auth_grapg"
    const val MAIN_GRAPH = "main_grabg"

    const val MENU_ROUTE = "home"
    const val GLASS_ROUTE = "glass_route"
    const val ACCOUNT_DATA_ROUTE = "accountdata"
    const val ACCOUNT_PASSWORD_ROUTE = "accountpassword"
    const val COCKTAIL_DETAIL_ROUTE: CocktailRoute = "lookup.php/{id}"
    const val INGREDIENT_DETAIL_ROUTE: CocktailRoute = "lookup.php/{iid}"
    const val GLASS_DETAIL_ROUTE: CocktailRoute = "list.php/g=list"
    const val NON_ALCOHOLIC_ROUTE = "non_alcoholic_route"
    const val ALCOHOLIC_ROUTE = "alcoholic_route"
    const val CATEGORY_ROUTE = "category_route"
    const val INGREDIENTS_ROUTE = "ingredients_route"


    const val ARG_CODE = "code"
    const val ARG_GLASS_NAME = "glass_name"
    const val ARG_ID = "id"
    const val ARG_PAGE = "page"
    const val ARG_IID = "iid"  //ingredient id
}


val Bundle?.id get() = this?.getString(ARG_ID)
val Bundle?.iid get() = this?.getString(ARG_IID)

val Bundle?.name get() = this?.getString(ARG_GLASS_NAME)
fun CocktailRoute.withId(id: String): CocktailRoute = replace("{$ARG_ID}", id)
val Bundle?.page get() = this?.getString(ARG_PAGE)?.toIntOrNull()
fun CocktailRoute.withPage(page: Int): CocktailRoute = replace("{$ARG_PAGE}", page.toString())

@Composable
fun rememberCocktailNavActions(navController: NavController) = remember(navController) {
    CocktailNavActions(navController)
}

class CocktailNavActions(private val navController: NavController) : KoinComponent {
    val navigateToHome: () -> Unit = {
        navController.popBackStack(
            route = CoctailDestinations.MENU_ROUTE,
            inclusive = false,
            saveState = true,
        )
    }
    val navigateToGlasses: () -> Unit = {
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
        navController.navigate(CoctailDestinations.CATEGORY_ROUTE.withPage(it.ordinal)) {
            val primaryRoute: Int? = navController.currentBackStackEntry?.destination?.id
            val fallbackRoute: Int = navController.graph.findStartDestination().id
            popUpTo(primaryRoute ?: fallbackRoute) {
                saveState = true
            }
            launchSingleTop = true
            //           restoreState = true
        }
    }

    val navigateToMenu: () -> Unit = {
        navController.navigate(CoctailDestinations.MENU_ROUTE) {
            val primaryRoute: Int? = navController.currentBackStackEntry?.destination?.id
            val fallbackRoute: Int = navController.graph.findStartDestination().id
            popUpTo(primaryRoute ?: fallbackRoute) {
                saveState = true
            }
            launchSingleTop = true
            restoreState = true
        }
    }
    val navigateToCocktailDetails: (String) -> Unit = {
        navController.navigate(CoctailDestinations.COCKTAIL_DETAIL_ROUTE.withId(it)) {
            val primaryRoute: Int? = navController.currentBackStackEntry?.destination?.id
            val fallbackRoute: Int = navController.graph.findStartDestination().id
            popUpTo(primaryRoute ?: fallbackRoute) {
                saveState = true
            }
            launchSingleTop = true
            restoreState = true
        }
    }
    val navigateToIngredients: () -> Unit = {
        navController.navigate(CoctailDestinations.INGREDIENTS_ROUTE) {
            val primaryRoute: Int? = navController.currentBackStackEntry?.destination?.id
            val fallbackRoute: Int = navController.graph.findStartDestination().id
            popUpTo(primaryRoute ?: fallbackRoute) {
                saveState = true
            }
            launchSingleTop = true
            restoreState = true
        }
    }
    val navigateToIngredientDetails: (String) -> Unit = {
        navController.navigate(CoctailDestinations.INGREDIENT_DETAIL_ROUTE.withId(it)) {
            val primaryRoute: Int? = navController.currentBackStackEntry?.destination?.id
            val fallbackRoute: Int = navController.graph.findStartDestination().id
            popUpTo(primaryRoute ?: fallbackRoute) {
                saveState = true
            }
            launchSingleTop = true
            restoreState = true
        }
    }
}