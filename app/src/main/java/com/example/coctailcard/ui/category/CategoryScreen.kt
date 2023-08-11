package com.example.coctailcard.ui.category

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.calculateEndPadding
import androidx.compose.foundation.layout.calculateStartPadding
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.LayoutDirection
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
                .padding(
                    top = paddingValues.calculateTopPadding(),
                    start = paddingValues.calculateStartPadding(LayoutDirection.Ltr),
                    end = paddingValues.calculateEndPadding(LayoutDirection.Ltr)
                )
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
    val nonAlcoholicCocktails = viewModel.nonAlcoholicCocktails.collectAsState()
    val lazyColumnState = rememberLazyListState()
    Column(
        modifier = Modifier
            .padding(top = 16.dp, start = 16.dp, end = 16.dp)
            .fillMaxSize()
    ) {
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(12.dp),
            state = lazyColumnState,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            items(nonAlcoholicCocktails.value) { nonAlcoholicCocktail ->
                NonAlcoholicDrink(
                    nonAlcoholicCocktail = nonAlcoholicCocktail,
                    nonAlcoholicCocktailClick = { actions.navigateToCocktailDetails(it) }
                )
            }
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
    val alcoholicCocktails = viewModel.alcoholicCocktails.collectAsState()
    val lazyColumnState = rememberLazyListState()
    Column(
        modifier = Modifier
            .padding(top = 16.dp, start = 16.dp, end = 16.dp)
            .fillMaxSize()
    ) {
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(15.dp),
            state = lazyColumnState
        ) {
            items(alcoholicCocktails.value) { alcoholicCocktail ->
                AlcoholicDrink(
                    alcoholicCocktail = alcoholicCocktail,
                    alcoholicCocktailClick = { actions.navigateToCocktailDetails(it)  }
                )
            }
            item { Spacer(modifier = Modifier.height(paddingValues.calculateBottomPadding())) }
        }
    }
}

@Preview
@Composable
fun AlcoholicListScreenPreview() {
    AlcoholicListScreen(navController = rememberNavController())
}
