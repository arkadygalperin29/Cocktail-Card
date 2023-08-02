package com.example.coctailcard.ui.detailscreens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage
import com.example.coctailcard.data.network.models.Cocktail
import com.example.coctailcard.navigation.rememberCocktailNavActions
import com.example.coctailcard.ui.components.CoctailScaffold
import com.example.coctailcard.ui.components.scaffold.AppHeaderType
import com.example.coctailcard.ui.theme.Black1
import com.example.coctailcard.ui.theme.Grey50
import com.example.coctailcard.ui.theme.Header1
import com.example.coctailcard.ui.theme.Pink40
import com.example.coctailcard.ui.theme.RedClean
import com.example.coctailcard.ui.theme.Text14
import com.example.coctailcard.util.UiEvent
import com.example.coctailcard.util.paddingWithScroll
import org.koin.androidx.compose.koinViewModel


@Composable
fun CocktailDetailScreen(
    modifier: Modifier = Modifier,
    navController: NavController = rememberNavController(),
    id: String,
    viewModel: CocktailDetailViewModel = koinViewModel()
) {
    val actions = rememberCocktailNavActions(navController = navController)
    val cocktail = viewModel.cocktail.collectAsState()
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
        viewModel.getCocktailById(id)
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
            cocktail.value?.let { CocktailDetail(cocktail = it) }
        }
    }
}

@Composable
fun CocktailDetail(
    cocktail: Cocktail
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Pink40)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp, start = 16.dp, end = 16.dp, bottom = 16.dp)
                .background(color = Pink40)
        ) {
            AsyncImage(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(180.dp)
                    .clip(shape = RoundedCornerShape(16.dp))
                    .background(color = Color.Black)
                    .border(2.dp, Black1, shape = RoundedCornerShape(16.dp)),
                model = cocktail.drinkImage,
                contentDescription = null,
                contentScale = ContentScale.Crop
            )
        }
        if (!cocktail.name.isNullOrEmpty()) {
            cocktail.name?.let {
                Text(
                    text = it,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 16.dp),
                    style = Header1,
                    color = Grey50
                )
            }
        }
        if (!cocktail.alcoholic.isNullOrEmpty()) {
            cocktail.alcoholic?.let {
                Text(
                    text = it,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 16.dp, top = 16.dp, end = 16.dp),
                    style = Text14,
                    color = Grey50
                )
            }
        }
        if (!cocktail.category.isNullOrEmpty()) {
            cocktail.category?.let {
                Text(
                    text = it,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 16.dp, top = 16.dp, end = 16.dp),
                    style = Text14,
                    color = RedClean
                )
            }
        }
        if (!cocktail.glass.isNullOrEmpty()) {
            cocktail.glass?.let {
                Text(
                    text = it,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 16.dp, top = 16.dp, end = 16.dp),
                    style = Text14,
                    color = Grey50
                )
            }
        }
        if (!cocktail.instructions.isNullOrEmpty()) {
            cocktail.instructions?.let {
                Text(
                    text = it,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 16.dp, top = 16.dp, end = 16.dp),
                    style = Text14,
                    color = Grey50
                )
            }
        }
        if (!cocktail.strIngredient1.isNullOrEmpty()) {
            cocktail.strIngredient1?.let {
                Text(
                    text = it,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 16.dp, top = 16.dp, end = 16.dp),
                    style = Text14,
                    color = Grey50
                )
            }
        }
        if (!cocktail.strIngredient2.isNullOrEmpty()) {
            cocktail.strIngredient2?.let {
                Text(
                    text = it,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 16.dp, top = 16.dp, end = 16.dp),
                    style = Text14,
                    color = Grey50
                )
            }
        }
        if (!cocktail.strIngredient3.isNullOrEmpty()) {
            cocktail.strIngredient3?.let {
                Text(
                    text = it,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 16.dp, top = 16.dp, end = 16.dp),
                    style = Text14,
                    color = Grey50
                )
            }
        }
        if (!cocktail.strIngredient4.isNullOrEmpty()) {
            cocktail.strIngredient4?.let {
                Text(
                    text = it,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 16.dp, top = 16.dp, end = 16.dp),
                    style = Text14,
                    color = Grey50
                )
            }
        }
        if (!cocktail.strIngredient5.isNullOrEmpty()) {
            cocktail.strIngredient5?.let {
                Text(
                    text = it,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 16.dp, top = 16.dp, end = 16.dp),
                    style = Text14,
                    color = Grey50
                )
            }
        }
        if (!cocktail.strIngredient6.isNullOrEmpty()) {
            cocktail.strIngredient6?.let {
                Text(
                    text = it,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 16.dp, top = 16.dp, end = 16.dp),
                    style = Text14,
                    color = Grey50
                )
            }
        }
        if (!cocktail.strIngredient7.isNullOrEmpty()) {
            cocktail.strIngredient7?.let {
                Text(
                    text = it,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 16.dp, top = 16.dp, end = 16.dp),
                    style = Text14,
                    color = Grey50
                )
            }
        }
        if (!cocktail.strIngredient8.isNullOrEmpty()) {
            cocktail.strIngredient8?.let {
                Text(
                    text = it,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 16.dp, top = 16.dp, end = 16.dp),
                    style = Text14,
                    color = Grey50
                )
            }
        }
        if (!cocktail.strIngredient9.isNullOrEmpty()) {
            cocktail.strIngredient9?.let {
                Text(
                    text = it,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 16.dp, top = 16.dp, end = 16.dp),
                    style = Text14,
                    color = Grey50
                )
            }
        }
        if (!cocktail.strIngredient10.isNullOrEmpty()) {
            cocktail.strIngredient10?.let {
                Text(
                    text = it,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 16.dp, top = 16.dp, end = 16.dp),
                    style = Text14,
                    color = Grey50
                )
            }
        }
        if (!cocktail.strIngredient11.isNullOrEmpty()) {
            cocktail.strIngredient11?.let {
                Text(
                    text = it,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 16.dp, top = 16.dp, end = 16.dp),
                    style = Text14,
                    color = Grey50
                )
            }
        }
        if (!cocktail.strIngredient12.isNullOrEmpty()) {
            cocktail.strIngredient12?.let {
                Text(
                    text = it,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 16.dp, top = 16.dp, end = 16.dp),
                    style = Text14,
                    color = Grey50
                )
            }
        }
        if (!cocktail.strIngredient13.isNullOrEmpty()) {
            cocktail.strIngredient13?.let {
                Text(
                    text = it,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 16.dp, top = 16.dp, end = 16.dp),
                    style = Text14,
                    color = Grey50
                )
            }
        }
        if (!cocktail.strIngredient14.isNullOrEmpty()) {
            cocktail.strIngredient14?.let {
                Text(
                    text = it,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 16.dp, top = 16.dp, end = 16.dp),
                    style = Text14,
                    color = Grey50
                )
            }
        }
    }
}


@Preview
@Composable
fun PromotionDetailPreview() {
    CocktailDetail(
        cocktail = Cocktail(
            id = "1",
            name = "Margarita",
            category = "Alcoholic",
            alcoholic = "20%",
            glass = "simple",
            instructions = "Sprinkle a few teaspoons of salt over the surface of a small plate or saucer. Rub one wedge of lime along the rim of a tumbler and then dip it into the salt so that the entire rim is covered.",
            drinkImage = "1",
            strIngredient1 = "vodka",
            strIngredient2 = null,
            strIngredient3 = null,
            strIngredient4 = null,
            strIngredient5 = "123",
            strIngredient6 = null,
            strIngredient7 = null,
            strIngredient8 = null,
            strIngredient9 = null,
            strIngredient10 = null,
            strIngredient11 = null,
            strIngredient12 = null,
            strIngredient13 = null,
            strIngredient14 = null
        )
    )
}

@Preview
@Composable
fun CocktailDetailScreenPreview() {
    CocktailDetailScreen(id = "17222")
}