package com.example.coctailcard.ui.glassscreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.coctailcard.R
import com.example.coctailcard.ui.components.CoctailScaffold
import com.example.coctailcard.ui.theme.Pink40
import org.koin.androidx.compose.koinViewModel

@Composable
fun GlassScreen(
    modifier: Modifier = Modifier,
    navController: NavController = rememberNavController(),
    viewModel: GlassViewModel = koinViewModel(),
) {
    val glasses by viewModel.glasses.collectAsState()
    val lazyGridState = rememberLazyGridState()
    CoctailScaffold(
        modifier = modifier,
        navController = navController,
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Pink40)
                .padding(paddingValues),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 8.dp),
                state = lazyGridState,
                verticalArrangement = Arrangement.spacedBy(16.dp),
                horizontalArrangement = Arrangement.spacedBy(17.dp)
            ) {
                itemsIndexed(glasses) { index, glass ->
                    val drawableResId = getDrawableResIdForItem(index)
                    GlassSingleCard(glass = glass, onGlassClicked = { }, drawableResId)
                }
            }
        }
    }
}

private fun getDrawableResIdForItem(index: Int): Int {
    // Implement your logic to return the correct drawable/resource based on the index.
    // For example, you can use a when statement, or an array of drawables/resources.
    // For this example, we'll just return a hardcoded resource ID.
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
        24 -> R.drawable.pilsner_glass_beer
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


@Preview
@Composable
fun GlassScreenPreview() {
    GlassScreen()
}