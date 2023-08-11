package com.example.coctailcard.ui.ingredients

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
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
import com.example.coctailcard.ui.components.AppLoader
import com.example.coctailcard.ui.components.CoctailScaffold
import com.example.coctailcard.ui.theme.Black1
import com.example.coctailcard.ui.theme.Pink40
import org.koin.androidx.compose.koinViewModel

@Composable
fun IngredientsScreen(
    modifier: Modifier = Modifier,
    navController: NavController = rememberNavController(),
    viewModel: IngredientsViewModel = koinViewModel()
) {
    val context = LocalContext.current
    val ingredients by viewModel.ingredients.collectAsState()
    val state by viewModel.state.collectAsState()
    val lazyColumnState = rememberLazyListState()
    CoctailScaffold(
        modifier = modifier,
        navController = navController,
    ) { paddingValues ->
        if (state.isLoading) AppLoader()
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Black1)
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
                itemsIndexed(ingredients) { index, ingredients ->
                    val stringResId = getStringResourceId(index)
                    val drawableResId = getDrawableResIdForItem(index)
                    IngredientSingleCard(
                        ingredient = ingredients,
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
        0 -> R.drawable.light_rum
        1 -> R.drawable.applejack
        2 -> R.drawable.gin
        3 -> R.drawable.dark_rum
        4 -> R.drawable.sweet_vermout
        5 -> R.drawable.strawberry_schnapps
        6 -> R.drawable.scotch
        7 -> R.drawable.apricot_brandy
        8 -> R.drawable.triple_sec
        9 -> R.drawable.southern_comfort
        10 -> R.drawable.orange_bitters
        11 -> R.drawable.brandy
        12 -> R.drawable.lemon_vodka
        13 -> R.drawable.blended_whiskey
        14 -> R.drawable.dry_vermouth
        15 -> R.drawable.amaretto
        16 -> R.drawable.tea
        17 -> R.drawable.champagne
        18 -> R.drawable.coffe_liqueur
        19 -> R.drawable.bourbon
        20 -> R.drawable.tequila
        21 -> R.drawable.vodka
        22 -> R.drawable.anejo_rum
        23 -> R.drawable.bitters
        24 -> R.drawable.sugar
        25 -> R.drawable.kahlua
        26 -> R.drawable.demerara_sugar
        27 -> R.drawable.dubonnet_rouge
        28 -> R.drawable.watermelon
        29 -> R.drawable.lime_juice
        30 -> R.drawable.irish_whiskey
        31 -> R.drawable.apple_brandy
        32 -> R.drawable.carbonated_water
        33 -> R.drawable.cherry_brandy
        34 -> R.drawable.creme_de_cacao
        35 -> R.drawable.grenadine
        36 -> R.drawable.port
        37 -> R.drawable.coffee_brandy
        38 -> R.drawable.red_wine
        39 -> R.drawable.rum
        40 -> R.drawable.grapefruit_juice
        41 -> R.drawable.ricard
        42 -> R.drawable.sherry
        43 -> R.drawable.cognac
        44 -> R.drawable.sloe_gin
        45 -> R.drawable.apple_juice
        46 -> R.drawable.pineapple_juice
        47 -> R.drawable.lemon_juice
        48 -> R.drawable.sugar_syrup
        49 -> R.drawable.milk
        50 -> R.drawable.strawberries
        51 -> R.drawable.chocolate_syrup
        52 -> R.drawable.yoghurt
        53 -> R.drawable.mango
        54 -> R.drawable.ginger
        55 -> R.drawable.lime
        56 -> R.drawable.cantaloupe
        57 -> R.drawable.berries
        58 -> R.drawable.grapes
        59 -> R.drawable.kiwi
        60 -> R.drawable.tomato_juice
        61 -> R.drawable.cocoa_powder
        62 -> R.drawable.chocolate
        63 -> R.drawable.heavy_cream
        64 -> R.drawable.galliano
        65 -> R.drawable.peach_vodka
        66 -> R.drawable.ouzo
        67 -> R.drawable.coffee
        68 -> R.drawable.spiced_rum
        69 -> R.drawable.water
        70 -> R.drawable.espresso
        71 -> R.drawable.angelica_root
        72 -> R.drawable.orange
        73 -> R.drawable.cranberries
        74 -> R.drawable.johnie_walker
        75 -> R.drawable.apple_cider
        76 -> R.drawable.everclear
        77 -> R.drawable.cranberry_juice
        78 -> R.drawable.egg_yolk
        79 -> R.drawable.egg
        80 -> R.drawable.grape_juice
        81 -> R.drawable.peach_nectar
        82 -> R.drawable.lemon
        83 -> R.drawable.firewater
        84 -> R.drawable.lemonade
        85 -> R.drawable.lager
        86 -> R.drawable.whiskey
        87 -> R.drawable.absolut_citron
        88 -> R.drawable.pisco
        89 -> R.drawable.irish_cream
        90 -> R.drawable.ale
        91 -> R.drawable.chocolate_liqueur
        92 -> R.drawable.midori_melon
        93 -> R.drawable.sambuka
        94 -> R.drawable.cider
        95 -> R.drawable.sprite
        96 -> R.drawable.seven_up
        97 -> R.drawable.blackberry_brandy
        98 -> R.drawable.peppermint_schnapps
        99 -> R.drawable.creme_de_cassis
        // Add more cases for other items as needed.
        else -> R.drawable.vodka
    }
}

private fun getStringResourceId(index: Int): Int {
    return when (index) {
        0 -> R.string.light_rum_description
        1 -> R.string.applejack_description
        2 -> R.string.gin_description
        3 -> R.string.dark_rum_description
        4 -> R.string.sweet_vermout_description
        5 -> R.string.strawberry_schnapps_description
        6 -> R.string.scotch_description
        7 -> R.string.apricot_brandy_description
        8 -> R.string.triple_sec_description
        9 -> R.string.southern_comfort_description
        10 -> R.string.orange_bitters_description
        11 -> R.string.brandy_description
        12 -> R.string.lemon_vodka_description
        13 -> R.string.blended_whiskey_description
        14 -> R.string.dry_vermouth_description
        15 -> R.string.amaretto_description
        16 -> R.string.tea_description
        17 -> R.string.champagne_description
        18 -> R.string.coffee_liqueur_description
        19 -> R.string.bourbon_description
        20 -> R.string.tequila_description
        21 -> R.string.vodka_description
        22 -> R.string.aneyo_rum_description
        23 -> R.string.bitters_description
        24 -> R.string.sugar_description
        25 -> R.string.kahlua_description
        26 -> R.string.demerara_sugar_description
        27 -> R.string.dubonnet_rouge_description
        28 -> R.string.watermelon_description
        29 -> R.string.lime_juice_description
        30 -> R.string.irish_whiskey_description
        31 -> R.string.apple_brandy_description
        32 -> R.string.carbonated_water_description
        33 -> R.string.cherry_brandy_description
        34 -> R.string.creme_de_cacao_description
        35 -> R.string.grenadine_description
        36 -> R.string.port_description
        37 -> R.string.coffee_brandy_description
        38 -> R.string.red_wine_description
        39 -> R.string.rum_description
        40 -> R.string.grapefruit_juice_description
        41 -> R.string.ricard_description
        42 -> R.string.sherry_description
        43 -> R.string.cognac_description
        44 -> R.string.sloe_gin_description
        45 -> R.string.apple_juice_description
        46 -> R.string.pineapple_juice_description
        47 -> R.string.lemon_juice_description
        48 -> R.string.sugar_syrup_description
        49 -> R.string.milk_description
        50 -> R.string.strawberries_description
        51 -> R.string.chocolate_syrup_description
        52 -> R.string.yoghurt_description
        53 -> R.string.mango_description
        54 -> R.string.ginger_description
        55 -> R.string.lime_description
        56 -> R.string.cantaloupe_description
        57 -> R.string.berries_description
        58 -> R.string.grapes_description
        59 -> R.string.kiwi_description
        60 -> R.string.tomato_juice_description
        61 -> R.string.cocoa_powder_description
        62 -> R.string.chocolate_description
        63 -> R.string.heavy_cream_description
        64 -> R.string.galliano_description
        65 -> R.string.peach_vodka_description
        66 -> R.string.ouzo_description
        67 -> R.string.coffee_description
        68 -> R.string.spiced_rum_description
        69 -> R.string.water_description
        70 -> R.string.espresso_description
        71 -> R.string.angelica_root_description
        72 -> R.string.orange_description
        73 -> R.string.cranberries_description
        74 -> R.string.johnie_walker_description
        75 -> R.string.apple_cider_description
        76 -> R.string.everclear_description
        77 -> R.string.cranberry_juice_description
        78 -> R.string.egg_yolk_description
        79 -> R.string.egg_description
        80 -> R.string.grape_juice_description
        81 -> R.string.peach_nectar_description
        82 -> R.string.lemon_description
        83 -> R.string.firewater_description
        84 -> R.string.lemonade_description
        85 -> R.string.lager_description
        86 -> R.string.whiskey_description
        87 -> R.string.absolut_citron_description
        88 -> R.string.pisco_description
        89 -> R.string.irish_cream_description
        90 -> R.string.ale_description
        91 -> R.string.chocolate_liquer_description
        92 -> R.string.midori_melon_liqueur_description
        93 -> R.string.sambuca_description
        94 -> R.string.cider_description
        95 -> R.string.sprite_description
        96 -> R.string.seven_up_description
        97 -> R.string.blackberry_brandy_description
        98 -> R.string.peppermint_schnapps_description
        99 -> R.string.creme_de_cassis_description
        // Add more cases for other items as needed.
        else -> R.string.creme_de_cassis_description
    }
}

@Preview
@Composable
fun IngredientsScreenPreview() {
    IngredientsScreen()
}