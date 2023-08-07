package com.example.coctailcard.ui.glassscreen

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.coctailcard.R
import com.example.coctailcard.navigation.rememberCocktailNavActions
import com.example.coctailcard.ui.components.CoctailScaffold
import com.example.coctailcard.ui.theme.Grey50
import com.example.coctailcard.ui.theme.Pink40
import org.koin.androidx.compose.koinViewModel

@Composable
fun GlassScreen(
    modifier: Modifier = Modifier,
    navController: NavController = rememberNavController(),
    viewModel: GlassViewModel = koinViewModel(),
) {
    val context = LocalContext.current
    val glasses by viewModel.glasses.collectAsState()
    val lazyColumnState = rememberLazyListState()
    CoctailScaffold(
        modifier = modifier,
        navController = navController,
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Grey50)
                .padding(paddingValues),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 8.dp),
                state = lazyColumnState,
                verticalArrangement = Arrangement.spacedBy(16.dp),
            ) {
                itemsIndexed(glasses) { index, glass ->
                    val stringResId = getStringResourceId(index)
                    val drawableResId = getDrawableResIdForItem(index)
                    GlassSingleCard(
                        glass = glass,
                        onGlassClicked = {  },
                        drawableResId = drawableResId,
                        description = context.getString(stringResId)
                    )
                }
            }
        }
    }
}

private fun getDrawableResIdForItem(index: Int): Int {
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

private fun getStringResourceId(index: Int): Int {
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


@Preview
@Composable
fun GlassScreenPreview() {
    GlassScreen()
}