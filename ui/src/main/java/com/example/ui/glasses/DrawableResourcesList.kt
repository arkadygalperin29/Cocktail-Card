package com.example.ui.glasses

import com.example.ui.R

fun getDrawableResIdForItem(index: Int): Int {
    return when (index) {
        0 -> R.drawable.highball_glass
        1 -> R.drawable.cocktail_glass
        2 -> R.drawable.old_fashioned_glass
        3 -> R.drawable.whiskey_glass
        4 -> R.drawable.collins_glass
        5 -> R.drawable.pousse_cafe_glass
        6 -> R.drawable.champagne_glass
        7 -> R.drawable.whiskey_sour_glass
        8 -> R.drawable.cordial_glass
        9 -> R.drawable.brandy_snifter
        10 -> R.drawable.white_wine_glass
        11 -> R.drawable.nick_and_nora_glass
        12 -> R.drawable.hurricane_glass
        13 -> R.drawable.coffee_mug
        14 -> R.drawable.shot_glass
        15 -> R.drawable.jar
        16 -> R.drawable.irish_coffee_glass
        17 -> R.drawable.punch_bowl
        18 -> R.drawable.pitcher
        19 -> R.drawable.pint_glass
        20 -> R.drawable.copper_mug
        21 -> R.drawable.wine_glass_png
        22 -> R.drawable.beer_mug
        23 -> R.drawable.margarita_coupette_glass
        24 -> R.drawable.beer_pilsner
        25 -> R.drawable.beer_cocktail_glass
        26 -> R.drawable.parfait_glass
        27 -> R.drawable.mason_jar_png
        28 -> R.drawable.margarita_coupette_glass
        29 -> R.drawable.martini_glass
        30 -> R.drawable.balloon_glass
        31 -> R.drawable.coupe_glass
        // Add more cases for other items as needed.
        else -> R.drawable.coupe_glass
    }
}