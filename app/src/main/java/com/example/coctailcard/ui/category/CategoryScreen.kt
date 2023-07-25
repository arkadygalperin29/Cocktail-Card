package com.example.coctailcard.ui.category

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.calculateEndPadding
import androidx.compose.foundation.layout.calculateStartPadding
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.coctailcard.R
import com.example.coctailcard.ui.components.CategoryTabs
import com.example.coctailcard.ui.components.CoctailScaffold
import com.example.coctailcard.ui.theme.Grey1000

@Composable
fun CategoryScreen(
    modifier: Modifier = Modifier,
    navController: NavController = rememberNavController(),
) {
 //   val state by viewModel.state.collectAsState()
    CoctailScaffold(
        modifier = modifier,
        navController = navController
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .background(Grey1000)
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
                selected = 1,
                onItemSelected = {
 /*                   viewModel.updateState(
                        state.copy(
                            selectedButton = it
                        )
                    )*/
                }
            )
/*            when (state.selectedButton) {
                CategoriesSelection.ALCOHOLIC.ordinal -> {}
                CategoriesSelection.NON_ALCOHOLIC.ordinal -> {}
            }*/
        }
    }
}


@Composable
@Preview
fun CategoryScreenPreview() {
    CategoryScreen()
}