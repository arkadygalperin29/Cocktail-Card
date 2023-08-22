package com.example.coctailcard.ui.ingredients

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
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
import com.example.coctailcard.ui.components.CoctailScaffold
import com.example.coctailcard.ui.components.scaffold.AppHeaderType
import com.example.ui.appcomponents.AppLoader
import com.example.ui.ingredients.IngredientSingleCard
import com.example.ui.ingredients.getDrawableResIdForItem
import com.example.ui.ingredients.getStringResourceId
import com.example.ui.theme.Black1
import org.koin.androidx.compose.koinViewModel

@Composable
fun IngredientsScreen(
    modifier: Modifier = Modifier,
    navController: NavController = rememberNavController(),
    viewModel: IngredientsViewModel = koinViewModel(),
) {
    val context = LocalContext.current
    val state by viewModel.state.collectAsState()
    val lazyColumnState = rememberLazyListState()
    CoctailScaffold(
        modifier = modifier,
        navController = navController,
        topBarType = AppHeaderType.WithButtons(
            onRetrunClick = { navController.popBackStack() }
        )
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
                    .offset(y = (16.dp)),
                state = lazyColumnState,
                verticalArrangement = Arrangement.spacedBy(16.dp),
            ) {
                itemsIndexed(state.ingredients) { index, ingredients ->
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


@Preview
@Composable
fun IngredientsScreenPreview() {
    IngredientsScreen()
}