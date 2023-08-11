package com.example.coctailcard.ui.menuscreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.coctailcard.navigation.rememberCocktailNavActions
import com.example.coctailcard.ui.components.AppLoader
import com.example.coctailcard.ui.components.CoctailScaffold
import com.example.coctailcard.ui.components.SearchBar
import com.example.coctailcard.ui.theme.Pink40
import org.koin.androidx.compose.koinViewModel

@Composable
fun MenuScreen(
    modifier: Modifier = Modifier,
    navController: NavController = rememberNavController(),
    viewModel: MenuScreenViewModel = koinViewModel(),
) {
    val actions = rememberCocktailNavActions(navController = navController)
    val state by viewModel.state.collectAsState()
    val lazyGridState = rememberLazyGridState()

    LaunchedEffect(state.searchQuery) {
        viewModel.fetchCocktails(state.searchQuery)
    }

    CoctailScaffold(
        modifier = modifier,
        navController = navController,
    ) { paddingValues ->
        if (state.isLoading) AppLoader()
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Pink40)
                .padding(paddingValues),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            SearchBar(onSearch = { query ->
                viewModel.setSearchQuery(query)
            })
            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 8.dp),
                state = lazyGridState,
                verticalArrangement = Arrangement.spacedBy(16.dp),
                horizontalArrangement = Arrangement.spacedBy(17.dp)
            ) {
                items(state.cocktails) { cocktail ->
                    CocktailSingleCard(
                        cocktail = cocktail,
                        onCocktailClicked = { actions.navigateToCocktailDetails(it) })
                }
            }
        }
    }
}

@Preview
@Composable
fun MenuScreenPreview() {
    MenuScreen()
}