package com.example.coctailcard.ui.category

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.coctailcard.R
import com.example.coctailcard.navigation.CocktailNavActions
import com.example.coctailcard.ui.components.AppLoader
import com.example.coctailcard.ui.components.CategoryTabs
import com.example.coctailcard.ui.components.CoctailScaffold
import com.example.coctailcard.ui.theme.Pink40
import org.koin.androidx.compose.koinViewModel

@Composable
fun CategoryScreen(
    modifier: Modifier = Modifier,
    navController: NavController = rememberNavController(),
    viewModel: CategoryViewModel = koinViewModel()
) {
    val state by viewModel.state.collectAsState()
    CoctailScaffold(
        modifier = modifier,
        navController = navController
    ) { paddingValues ->
        if (state.isLoading) AppLoader()
        Column(
            modifier = Modifier
                .background(Pink40)
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            CategoryTabs(
                modifier = Modifier.padding(
                    top = 16.dp,
                    end = 16.dp,
                    start = 16.dp
                ),
                options = listOf(
                    stringResource(id = R.string.alcoholic),
                    stringResource(id = R.string.nonalcoholic)
                ),
                selected = state.selectedButton,
                onItemSelected = {
                    viewModel.updateState(
                        state.copy(
                            selectedButton = it
                        )
                    )
                }
            )
            when (state.selectedButton) {
                CategoriesSelection.ALCOHOLIC.ordinal -> {
                    AlcoholicListScreen(
                        navController = navController,
                        paddingValues = paddingValues
                    )
                }

                CategoriesSelection.NON_ALCOHOLIC.ordinal -> {
                    NonAlcoholicListScreen(
                        navController = navController,
                        paddingValues = paddingValues
                    )
                }
            }
        }
    }
}

@Composable
fun NonAlcoholicListScreen(
    viewModel: CategoryViewModel = koinViewModel(),
    navController: NavController,
    paddingValues: PaddingValues = PaddingValues()
) {
    val actions = CocktailNavActions(navController)
    val state by viewModel.state.collectAsState()
    val lazyGridState = rememberLazyGridState()
    Column(
        modifier = Modifier
            .padding(start = 16.dp, end = 16.dp)
            .fillMaxSize()
    ) {
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            modifier = Modifier.offset(y = (16.dp)),
            verticalArrangement = Arrangement.spacedBy(15.dp),
            horizontalArrangement = Arrangement.spacedBy(17.dp),
            state = lazyGridState
        ) {
            items(state.nonAlcoholicCocktails) { nonAlcoholicCocktail ->
                NonAlcoholicDrink(
                    nonAlcoholicCocktail = nonAlcoholicCocktail,
                    nonAlcoholicCocktailClick = { actions.navigateToCocktailDetails(it) }
                )
            }
            item { Spacer(modifier = Modifier.height(8.dp)) }
        }
    }
}

@Composable
fun AlcoholicListScreen(
    viewModel: CategoryViewModel = koinViewModel(),
    navController: NavController,
    paddingValues: PaddingValues = PaddingValues()
) {
    val actions = CocktailNavActions(navController)
    val state by viewModel.state.collectAsState()
    val lazyGridState = rememberLazyGridState()

    Column(
        modifier = Modifier
            .padding(start = 16.dp, end = 16.dp)
            .fillMaxSize()
    ) {
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            modifier = Modifier.offset(y = (16.dp)),
            verticalArrangement = Arrangement.spacedBy(15.dp),
            horizontalArrangement = Arrangement.spacedBy(17.dp),
            state = lazyGridState
        ) {
            items(state.alcoholicCocktails) { alcoholicCocktail ->
                AlcoholicDrink(
                    alcoholicCocktail = alcoholicCocktail,
                    alcoholicCocktailClick = { actions.navigateToCocktailDetails(it) }
                )
            }
            item { Spacer(modifier = Modifier.height(8.dp)) }
        }
    }
}

@Preview
@Composable
fun AlcoholicListScreenPreview() {
    AlcoholicListScreen(navController = rememberNavController())
}
