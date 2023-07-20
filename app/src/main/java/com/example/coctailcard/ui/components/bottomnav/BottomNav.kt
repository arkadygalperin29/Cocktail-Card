package com.example.coctailcard.ui.components.bottomnav

import com.example.coctailcard.R
import com.example.coctailcard.navigation.CoctailDestinations

sealed class BottomNavItem(
    var title: String,
    var icon: Int,
    var screenRoute: String,
    var action: CoctailDestinations.() -> Unit
) {

    object Start :
        BottomNavItem(
            "Start",
            R.drawable.baseline_home_24,
            CoctailDestinations.MENU_ROUTE,
            { })

    object Offers :
        BottomNavItem(
            "Recipes",
            R.drawable.recipes,
            CoctailDestinations.MENU_ROUTE,
            { })

    object CardKSK :
        BottomNavItem(
            "Coctails",
            R.drawable.baseline_cup,
            CoctailDestinations.MENU_ROUTE,
            {  })

    object PercentageList :
        BottomNavItem(
            "Degree",
            R.drawable.alcoholic_percentage,
            CoctailDestinations.MENU_ROUTE,
            { })

    object More :
        BottomNavItem(
            "Glasses",
            R.drawable.baseline_cup,
            CoctailDestinations.MENU_ROUTE,
            {  })
}