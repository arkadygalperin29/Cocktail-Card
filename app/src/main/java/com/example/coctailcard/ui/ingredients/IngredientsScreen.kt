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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.coctailcard.R
import com.example.coctailcard.ui.components.CoctailScaffold
import com.example.coctailcard.ui.theme.Pink40
import org.koin.androidx.compose.koinViewModel

@Composable
fun IngredientsScreen(
    modifier: Modifier = Modifier,
    navController: NavController = rememberNavController(),
    viewModel: IngredientsViewModel = koinViewModel()
) {
    val ingredients by viewModel.ingredients.collectAsState()
    val lazyColumnState = rememberLazyListState()
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
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 8.dp),
                state = lazyColumnState,
                verticalArrangement = Arrangement.spacedBy(16.dp),
            ) {
                items(ingredients.size) {
                    IngredientSingleCard(ingredient = ingredients[0], drawableResId = R.drawable.vodka, description = "213")
                }
            }
        }
    }
}

@Preview
@Composable
fun IngredientsScreenPreview() {
    IngredientsScreen()
}