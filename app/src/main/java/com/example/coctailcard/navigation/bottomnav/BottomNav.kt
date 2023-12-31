package com.example.coctailcard.navigation.bottomnav

import com.example.coctailcard.R
import com.example.coctailcard.navigation.CoctailDestinations
import com.example.coctailcard.navigation.CocktailNavActions
import com.example.coctailcard.ui.category.CategoriesSelection

sealed class BottomNavItem(
    var title: String,
    var icon: Int,
    var screenRoute: String,
    var action: CocktailNavActions.() -> Unit
) {


    object Start :
        BottomNavItem(
            "Start",
            R.drawable.baseline_home_24,
            CoctailDestinations.MENU_ROUTE,
            { navigateToMenu() })

    object Categories :
        BottomNavItem(
            "Categories",
            R.drawable.categories,
            CoctailDestinations.CATEGORY_ROUTE,
            { navigateToCategory(CategoriesSelection.ALCOHOLIC) })

    object Cocktails :
        BottomNavItem(
            "Coctails",
            R.drawable.cocktail,
            CoctailDestinations.CATEGORY_ROUTE,
            { navigateToFavorites()})

    object SortByDegree :
        BottomNavItem(
            "Ingredients",
            R.drawable.ingredients,
            CoctailDestinations.MENU_ROUTE,
            { navigateToIngredients() })

    object Glasses :
        BottomNavItem(
            "Glasses",
            R.drawable.baseline_cup,
            CoctailDestinations.MENU_ROUTE,
            { navigateToGlasses() })
}