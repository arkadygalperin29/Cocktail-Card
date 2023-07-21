package com.example.coctailcard.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import org.koin.core.component.KoinComponent


typealias CoctailRoute = String

object CoctailDestinations {
    const val AUTH_GRAPH = "auth_grapg"
    const val MAIN_GRAPH = "main_grabg"

    const val MENU_ROUTE = "home"
    const val OFFERS_ROUTE: CoctailRoute = "offers/{page}"
    const val LOGIN_ROUTE = "login"
    const val FORGOT_PASSWORD_ROUTE = "forgotpassword"
    const val FORGOT_PASSWORD_SUCCESS_ROUTE = "forgotpasswordsuccess"
    const val REGISTER_ROUTE = "register"
    const val SUCCESSFUL_REGISTRATION_ROUTE = "successful_registration"
    const val SCANNER_FOR_CARD_CODE_REGISTRATION = "scanner_for_card_code_registration"
    const val MAP_ROUTE = "map"
    const val GLASS_ROUTE = "glass_route"
    const val ACCOUNT_DATA_ROUTE = "accountdata"
    const val ACCOUNT_PASSWORD_ROUTE = "accountpassword"
    const val COUPON_ROUTE: CoctailRoute = "coupon/{id}"
    const val PROMOTION_ROUTE: CoctailRoute = "promotion/{id}"
    const val STATION_ROUTE: CoctailRoute = "station/{id}"
    const val EMPTY_COUPON_LIST_ROUTE = "empty_coupon_list_route"
    const val EMPTY_PROMOTION_LIST_ROUTE = "empty_promotion_list_route"
    const val TERMS_AND_CONDITIONS_LIST_ROUTE = "terms_and_conditions_list_route"
    const val LOYALTY_CARD_ROUTE = "loyalty_card_route"
    const val INBOX_ROUTE = "inbox"


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
}