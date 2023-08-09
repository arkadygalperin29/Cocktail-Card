package com.example.coctailcard.ui.ingredients

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.coctailcard.data.network.models.IngredientDetailed
import com.example.coctailcard.navigation.rememberCocktailNavActions
import com.example.coctailcard.ui.components.CoctailScaffold
import com.example.coctailcard.ui.components.scaffold.AppHeaderType
import com.example.coctailcard.ui.theme.Grey50
import com.example.coctailcard.ui.theme.Header1
import com.example.coctailcard.ui.theme.Pink40
import com.example.coctailcard.util.UiEvent
import com.example.coctailcard.util.paddingWithScroll
import kotlinx.coroutines.delay
import org.koin.androidx.compose.koinViewModel

@Composable
fun IngredientDetailScreen(
    modifier: Modifier = Modifier,
    navController: NavController = rememberNavController(),
    iid: String,
    viewModel: IngredientsViewModel = koinViewModel()
) {
    val actions = rememberCocktailNavActions(navController = navController)
    val ingredient = viewModel.ingredient.collectAsState()
    val scrollState = rememberScrollState()

    LaunchedEffect(true) {
        viewModel.uiEvent.collect { event ->
            when (event) {
                is UiEvent.NavigateTo -> event.navAction(actions)
                else -> {}
            }
        }
    }
    LaunchedEffect(key1 = true) {
        delay(2000L)
        viewModel.fetchIngredientById(id = iid)
    }
    CoctailScaffold(
        modifier = modifier,
        navController = navController,
        topBarType = AppHeaderType.WithButtons(
            title = "Description",
            onRetrunClick = { navController.popBackStack() }
        ),
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Pink40)
                .paddingWithScroll(paddingValues, scrollState),
        ) {
            ingredient.value?.let { IngredientDetail(ingredientDetailed = it) }
        }
    }

}

@Composable
fun IngredientDetail(
    ingredientDetailed: IngredientDetailed,
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Pink40)
    ) {
        /*Box(    Add the static images later.
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp, start = 16.dp, end = 16.dp, bottom = 16.dp)
                .background(color = Pink40)
        ) {
            AsyncImage(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(350.dp)
                    .clip(shape = RoundedCornerShape(16.dp))
                    .background(color = Color.Black)
                    .border(2.dp, Black1, shape = RoundedCornerShape(16.dp)),
                model = ingredientDetailed.glassType,
                contentDescription = null,
                contentScale = ContentScale.Crop
            )
        }*/
        if (ingredientDetailed.name.isNotEmpty()) {
            Text(
                text = ingredientDetailed.name,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp),
                textAlign = TextAlign.Center,
                style = Header1,
                color = Grey50
            )
        }
        if (ingredientDetailed.description.isNotEmpty()) {
            Text(
                text = ingredientDetailed.description,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp),
                textAlign = TextAlign.Center,
                style = Header1,
                color = Grey50
            )
        }
        if (ingredientDetailed.glassType.isNotEmpty()) {
            Text(
                text = ingredientDetailed.glassType,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp),
                textAlign = TextAlign.Center,
                style = Header1,
                color = Grey50
            )
        }
        if (ingredientDetailed.isAlcoholic.isNotEmpty()) {
            Text(
                text = ingredientDetailed.isAlcoholic,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp),
                textAlign = TextAlign.Center,
                style = Header1,
                color = Grey50
            )
        }
        if (!ingredientDetailed.alcoholicVolume.isNullOrEmpty()) {
            ingredientDetailed.alcoholicVolume?.let {
                Text(
                    text = it,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 16.dp),
                    textAlign = TextAlign.Center,
                    style = Header1,
                    color = Grey50
                )
            }
        }
    }
}

@Preview
@Composable
fun IngredientDetailPreview() {
    IngredientDetail(
        ingredientDetailed = IngredientDetailed(
            "123",
            "Vodka",
            "Pour this vodka in a glass and drink it",
            "Square",
            "Alcoholic",
            "45%"
        )
    )
}

@Preview
@Composable
fun IngredientDetailScreenPreview() {
    IngredientDetailScreen(iid = "552")
}