package com.example.coctailcard.navigation.bottomnav

import com.example.coctailcard.R
import com.example.coctailcard.navigation.CoctailDestinations
import com.example.coctailcard.navigation.CoctailNavActions
import com.example.coctailcard.navigation.rememberCoctailNavActions
import com.example.coctailcard.ui.category.CategoriesSelection

sealed class BottomNavItem(
    var title: String,
    var icon: Int,
    var screenRoute: String,
    var action: CoctailNavActions.() -> Unit
) {


    object Start :
        BottomNavItem(
            "Start",
            R.drawable.baseline_home_24,
            CoctailDestinations.MENU_ROUTE,
            { })

    object Offers :
        BottomNavItem(
            "Categories",
            R.drawable.categories,
            CoctailDestinations.CATEGORY_ROUTE,
            { navigateToCategory(CategoriesSelection.ALCOHOLIC) })

    object CardKSK :
        BottomNavItem(
            "Coctails",
            R.drawable.cocktail,
            CoctailDestinations.CATEGORY_ROUTE,
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