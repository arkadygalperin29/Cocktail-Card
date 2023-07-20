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
            R.drawable.cocktail_main_icon,
            CoctailDestinations.MENU_ROUTE,
            {  })

    object Stations :
        BottomNavItem(
            "Sort by alcohol %",
            R.drawable.alcoholic_percentage,
            CoctailDestinations.MENU_ROUTE,
            { })

    object More :
        BottomNavItem(
            "Glasses",
            R.drawable.empty_glass_icon,
            CoctailDestinations.MENU_ROUTE,
            {  })
}