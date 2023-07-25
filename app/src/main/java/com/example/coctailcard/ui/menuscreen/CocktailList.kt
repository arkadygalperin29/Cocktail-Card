package com.example.coctailcard.ui.menuscreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import org.koin.androidx.compose.koinViewModel

@Composable
fun InitialCocktailList(
    navController: NavController,
    viewModel: MenuScreenViewModel = koinViewModel(),
    paddingValues: PaddingValues = PaddingValues()
) {
    val lazyColumnState = rememberLazyListState()
    Column(
        modifier = Modifier
            .padding(
                top = 16.dp, start = 16.dp, end = 16.dp
            )
    ) {
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(12.dp),
            state = lazyColumnState
        ) {

        }
    }
}

@Preview
@Composable
fun InitialCocktailListPreview() {
    InitialCocktailList(navController = rememberNavController())
}