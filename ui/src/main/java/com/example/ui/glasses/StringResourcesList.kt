package com.example.ui.glasses

import com.example.ui.R

fun getStringResourceId(index: Int): Int {
    return when (index) {
        0 -> R.string.highball_glass_description
        1 -> R.string.cocktail_glass_description
        2 -> R.string.old_fashioned_glass_description
        3 -> R.string.whiskey_glass_description
        4 -> R.string.collins_glass_description
        5 -> R.string.pousse_cafe_glass_description
        6 -> R.string.champagne_glass_description
        7 -> R.string.whiskey_glass_description
        8 -> R.string.cordial_glass_description
        9 -> R.string.brandy_snifter_description
        10 -> R.string.white_wine_glass_description
        11 -> R.string.nick_and_nora_glass_description
        12 -> R.string.hurricane_glass_description
        13 -> R.string.coffee_mug_description
        14 -> R.string.shot_glass_description
        15 -> R.string.jar_description
        16 -> R.string.irish_coffee_glass_description
        17 -> R.string.punch_bowl_description
        18 -> R.string.pitcher_description
        19 -> R.string.pint_glass_description
        20 -> R.string.copper_mug_description
        21 -> R.string.white_wine_glass_description
        22 -> R.string.beer_mug_description
        23 -> R.string.margarita_coupette_glass_description
        24 -> R.string.pilsner_glass_beer_description
        25 -> R.string.beer_cocktail_glass_description
        26 -> R.string.parfait_glass_description
        27 -> R.string.mason_jar_description
        28 -> R.string.margarita_coupette_glass_description
        29 -> R.string.martini_glass_description
        30 -> R.string.balloon_glass_description
        31 -> R.string.coupe_glass_description
        // Add more cases for other items as needed.
        else -> R.string.coupe_glass_description
    }
}
