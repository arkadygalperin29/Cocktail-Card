package com.example.coctailcard.ui.favorites

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.coctailcard.R
import com.example.coctailcard.navigation.rememberCocktailNavActions
import com.example.coctailcard.ui.components.CoctailScaffold
import com.example.coctailcard.ui.components.scaffold.AppHeaderType
import com.example.ui.favorites.FavoriteCocktail
import com.example.ui.theme.Grey100
import com.example.ui.theme.Grey50
import com.example.ui.theme.Pink40
import com.example.ui.theme.Text14
import org.koin.androidx.compose.koinViewModel

@Composable
fun FavoritesScreen(
    modifier: Modifier = Modifier,
    navController: NavController = rememberNavController(),
    viewModel: FavoritesViewModel = koinViewModel()
) {
    val state by viewModel.state.collectAsState()
    val lazyColumnState = rememberLazyListState()
    val actions = rememberCocktailNavActions(navController = navController)

    CoctailScaffold(
        modifier = modifier,
        navController = navController,
        topBarType = AppHeaderType.WithButtons(
            onRetrunClick = { navController.popBackStack() }
        )
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Pink40)
                .padding(paddingValues),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = stringResource(R.string.your_favorite_cocktails),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 8.dp),
                color = Grey100,
                style = Text14,
                textAlign = TextAlign.Center
            )
            Text(
                text = stringResource(
                    id = R.string.totally_saved,
                    state.favoriteCocktails.size.toString()
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 8.dp),
                color = Grey100,
                style = Text14,
                textAlign = TextAlign.Center
            )
            LazyColumn(
                modifier = Modifier
                    .offset(y = (16.dp))
                    .clip(RoundedCornerShape(16.dp))
                    .background(color = Grey50)
                    .border(8.dp, Grey50, shape = RoundedCornerShape(16.dp)),
                verticalArrangement = Arrangement.spacedBy(15.dp),
                state = lazyColumnState
            ) {
                items(state.favoriteCocktails) { favoriteCocktail ->
                    FavoriteCocktail(
                        favoriteCocktail = favoriteCocktail,
                        favoriteCocktailClick = { actions.navigateToCocktailDetails(it) },
                        deleteFavoriteCocktailClick = {
                            viewModel.deleteFavorite(
                                favoriteCocktail = favoriteCocktail
                            )
                        })
                }
            }
        }
    }
}

@Preview
@Composable
fun FavoritesScreenPreview() {
    FavoritesScreen()
}