package com.example.coctailcard.ui.detailscreens

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.ExperimentalTextApi
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withAnnotation
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage
import com.example.coctailcard.R
import com.example.coctailcard.navigation.rememberCocktailNavActions
import com.example.ui.appcomponents.AppLoader
import com.example.coctailcard.ui.components.CoctailScaffold
import com.example.coctailcard.ui.components.scaffold.AppHeaderType
import com.example.coctailcard.util.UiEvent
import com.example.coctailcard.util.paddingWithScroll
import com.example.domain.Cocktail
import com.example.ui.theme.Aubergine
import com.example.ui.theme.Black1
import com.example.ui.theme.CoolWhite
import com.example.ui.theme.Cream
import com.example.ui.theme.Grey50
import com.example.ui.theme.MiddleGreen
import com.example.ui.theme.MintGreen
import com.example.ui.theme.PaleGray
import com.example.ui.theme.Peach
import com.example.ui.theme.PeriWinkle1
import com.example.ui.theme.Pink40
import com.example.ui.theme.Red1
import com.example.ui.theme.RoseGold1
import com.example.ui.theme.SealBrown
import com.example.ui.theme.SkyBlue
import com.example.ui.theme.SoftBlueGray
import com.example.ui.theme.Teal1
import com.example.ui.theme.TerraCotta
import com.example.ui.theme.Text14
import org.koin.androidx.compose.koinViewModel


@Composable
fun CocktailDetailScreen(
    modifier: Modifier = Modifier,
    navController: NavController = rememberNavController(),
    id: String,
    viewModel: CocktailDetailViewModel = koinViewModel()
) {
    val actions = rememberCocktailNavActions(navController = navController)
    val scrollState = rememberScrollState()
    val state by viewModel.state.collectAsState()
    val context = LocalContext.current

    LaunchedEffect(true) {
        viewModel.uiEvent.collect { event ->
            when (event) {
                is UiEvent.NavigateTo -> event.navAction(actions)
                is UiEvent.ShowToast -> {
                    when (event.toastType) {
                        IsCocktailSavedInDatabase.COCKTAIL_IS_NOT_SAVED -> context.getString(R.string.cocktail_is_remembered_successfully)
                        IsCocktailSavedInDatabase.COCKTAIL_IS_ALREADY_SAVED -> context.getString(R.string.cocktail_is_already_saved_as_favorite)
                        else -> null
                    }?.let { text ->
                        Toast.makeText(
                            context,
                            text,
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }
            }
        }
    }
    LaunchedEffect(key1 = true) {
        viewModel.getCocktailById(id)
    }

    if (state.isLoading) AppLoader()

    CoctailScaffold(
        modifier = modifier,
        navController = navController,
        topBarType = AppHeaderType.WithLogo(
            onRetrunClick = { navController.popBackStack() }
        )
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Pink40)
                .paddingWithScroll(paddingValues, scrollState),
        ) {
            state.cocktail?.let { CocktailDetail(cocktail = it, navController = navController) }
        }
    }
}

@OptIn(ExperimentalTextApi::class)
@Composable
fun CocktailDetail(
    cocktail: Cocktail,
    navController: NavController = rememberNavController()
) {
    val actions = rememberCocktailNavActions(navController = navController)
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
                    .height(350.dp)
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
                    textAlign = TextAlign.Center,
                    style = com.example.ui.theme.Header1,
                    color = Grey50
                )
            }
        }
        if (!cocktail.alcoholic.isNullOrEmpty()) {
            cocktail.alcoholic?.let {
                Text(
                    text = stringResource(R.string.type, it),
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
                    text = stringResource(R.string.category, it),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 16.dp, top = 16.dp, end = 16.dp),
                    style = Text14,
                    color = Grey50
                )
            }
        }
        if (!cocktail.glass.isNullOrEmpty()) {
            cocktail.glass?.let {
                Text(
                    text = stringResource(R.string.glass, it),
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
                    text = stringResource(R.string.instructions, it),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 16.dp, top = 16.dp, end = 16.dp),
                    style = Text14,
                    color = Grey50
                )
            }
        }
        if (!cocktail.tags.isNullOrEmpty()) {
            cocktail.tags?.let {
                Text(
                    text = stringResource(R.string.tags, it),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 16.dp, top = 16.dp, end = 16.dp),
                    style = Text14,
                    color = Grey50
                )
            }
        }
        if (!cocktail.videoLink.isNullOrEmpty()) {
            cocktail.videoLink?.let {
                val link = stringResource(id = R.string.watch_video)
                val videoLinkAnnotated = buildAnnotatedString {
                    withAnnotation(
                        tag = "URL",
                        annotation = cocktail.videoLink ?: ""
                    ) {
                        withStyle(
                            style = SpanStyle(
                                color = Red1,
                                textDecoration = TextDecoration.Underline
                            )
                        ) {
                            append(link)
                        }
                    }
                }
                val uriHandler = LocalUriHandler.current
                ClickableText(
                    text = videoLinkAnnotated,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 16.dp, top = 16.dp, end = 16.dp),
                    style = Text14,
                    onClick = {
                        videoLinkAnnotated.getStringAnnotations(tag = "URL", it, it)
                            .firstOrNull()?.let { stringAnnotation ->
                                uriHandler.openUri(stringAnnotation.item)
                            }
                    }
                )
            }
        }
        Text(
            text = stringResource(R.string.ingredients),
            modifier = Modifier.padding(start = 16.dp, top = 16.dp, end = 16.dp),
            style = Text14,
            color = Grey50
        )
        if (!cocktail.strIngredient1.isNullOrEmpty()) {
            cocktail.strIngredient1?.let { name ->
                Box(
                    modifier = Modifier
                        .padding(start = 16.dp, top = 16.dp)
                        .border
                            (2.dp, color = Black1, RoundedCornerShape(8.dp))
                        .wrapContentSize()
                        .background(color = Cream, shape = RoundedCornerShape(8.dp))
                        .clickable { actions.navigateToIngredientDetails(name) }
                ) {
                    Text(
                        text = name,
                        modifier = Modifier.padding(8.dp),
                        style = Text14,
                        color = Black1
                    )
                }
            }
        }
        if (!cocktail.strIngredient2.isNullOrEmpty()) {
            cocktail.strIngredient2?.let { name ->
                Box(
                    modifier = Modifier
                        .padding(start = 16.dp, top = 16.dp)
                        .border
                            (2.dp, color = Black1, RoundedCornerShape(8.dp))
                        .wrapContentSize()
                        .background(color = RoseGold1, shape = RoundedCornerShape(8.dp))
                        .clickable { actions.navigateToIngredientDetails(name) }
                ) {
                    Text(
                        text = name,
                        modifier = Modifier
                            .padding(8.dp),
                        style = Text14,
                        color = Grey50
                    )
                }
            }
        }
        if (!cocktail.strIngredient3.isNullOrEmpty()) {
            cocktail.strIngredient3?.let { name ->
                Box(
                    modifier = Modifier
                        .padding(start = 16.dp, top = 16.dp)
                        .border
                            (2.dp, color = Black1, RoundedCornerShape(8.dp))
                        .wrapContentSize()
                        .background(color = Peach, shape = RoundedCornerShape(8.dp))
                        .clickable { actions.navigateToIngredientDetails(name) }
                ) {
                    Text(
                        text = name,
                        modifier = Modifier
                            .padding(8.dp),
                        style = Text14,
                        color = Black1
                    )
                }
            }
        }
        if (!cocktail.strIngredient4.isNullOrEmpty()) {
            cocktail.strIngredient4?.let { name ->
                Box(
                    modifier = Modifier
                        .padding(start = 16.dp, top = 16.dp)
                        .border
                            (2.dp, color = Black1, RoundedCornerShape(8.dp))
                        .wrapContentSize()
                        .background(color = MintGreen, shape = RoundedCornerShape(8.dp))
                        .clickable { actions.navigateToIngredientDetails(name) }
                ) {
                    Text(
                        text = name,
                        modifier = Modifier
                            .padding(8.dp),
                        style = Text14,
                        color = Black1
                    )
                }
            }
        }
        if (!cocktail.strIngredient5.isNullOrEmpty()) {
            cocktail.strIngredient5?.let { name ->
                Box(
                    modifier = Modifier
                        .padding(start = 16.dp, top = 16.dp)
                        .border
                            (2.dp, color = Black1, RoundedCornerShape(8.dp))
                        .wrapContentSize()
                        .background(color = PaleGray, shape = RoundedCornerShape(8.dp))
                        .clickable { actions.navigateToIngredientDetails(name) }
                ) {
                    Text(
                        text = name,
                        modifier = Modifier
                            .padding(8.dp),
                        style = Text14,
                        color = Grey50
                    )
                }
            }
        }
        if (!cocktail.strIngredient6.isNullOrEmpty()) {
            cocktail.strIngredient6?.let { name ->
                Box(
                    modifier = Modifier
                        .padding(start = 16.dp, top = 16.dp)
                        .border
                            (2.dp, color = Black1, RoundedCornerShape(8.dp))
                        .wrapContentSize()
                        .background(color = SealBrown, shape = RoundedCornerShape(8.dp))
                        .clickable { actions.navigateToIngredientDetails(name) }
                ) {
                    Text(
                        text = name,
                        modifier = Modifier
                            .padding(8.dp),
                        style = Text14,
                        color = Grey50
                    )
                }
            }
        }
        if (!cocktail.strIngredient7.isNullOrEmpty()) {
            cocktail.strIngredient7?.let { name ->
                Box(
                    modifier = Modifier
                        .padding(start = 16.dp, top = 16.dp)
                        .border
                            (2.dp, color = Black1, RoundedCornerShape(8.dp))
                        .wrapContentSize()
                        .background(color = Teal1, shape = RoundedCornerShape(8.dp))
                        .clickable { actions.navigateToIngredientDetails(name) }
                ) {
                    Text(
                        text = name,
                        modifier = Modifier
                            .padding(8.dp),
                        style = Text14,
                        color = Grey50
                    )
                }
            }
        }
        if (!cocktail.strIngredient8.isNullOrEmpty()) {
            cocktail.strIngredient8?.let { name ->
                Box(
                    modifier = Modifier
                        .padding(start = 16.dp, top = 16.dp)
                        .border
                            (2.dp, color = Black1, RoundedCornerShape(8.dp))
                        .wrapContentSize()
                        .background(color = CoolWhite, shape = RoundedCornerShape(8.dp))
                        .clickable { actions.navigateToIngredientDetails(name) }
                ) {
                    Text(
                        text = name,
                        modifier = Modifier
                            .padding(8.dp),
                        style = Text14,
                        color = Black1
                    )
                }
            }
        }
        if (!cocktail.strIngredient9.isNullOrEmpty()) {
            cocktail.strIngredient9?.let { name ->
                Box(
                    modifier = Modifier
                        .padding(start = 16.dp, top = 16.dp)
                        .border
                            (2.dp, color = Black1, RoundedCornerShape(8.dp))
                        .wrapContentSize()
                        .background(color = Aubergine, shape = RoundedCornerShape(8.dp))
                        .clickable { actions.navigateToIngredientDetails(name) }
                ) {
                    Text(
                        text = name,
                        modifier = Modifier
                            .padding(8.dp),
                        style = Text14,
                        color = Grey50
                    )
                }
            }
        }
        if (!cocktail.strIngredient10.isNullOrEmpty()) {
            cocktail.strIngredient10?.let { name ->
                Box(
                    modifier = Modifier
                        .padding(start = 16.dp, top = 16.dp)
                        .border
                            (2.dp, color = Black1, RoundedCornerShape(8.dp))
                        .wrapContentSize()
                        .background(color = MiddleGreen, shape = RoundedCornerShape(8.dp))
                        .clickable { actions.navigateToIngredientDetails(name) }
                ) {
                    Text(
                        text = name,
                        modifier = Modifier
                            .padding(8.dp),
                        style = Text14,
                        color = Black1
                    )
                }
            }
        }
        if (!cocktail.strIngredient11.isNullOrEmpty()) {
            cocktail.strIngredient11?.let { name ->
                Box(
                    modifier = Modifier
                        .padding(start = 16.dp, top = 16.dp)
                        .border
                            (2.dp, color = Black1, RoundedCornerShape(8.dp))
                        .wrapContentSize()
                        .background(color = TerraCotta, shape = RoundedCornerShape(8.dp))
                        .clickable { actions.navigateToIngredientDetails(name) }
                ) {
                    Text(
                        text = name,
                        modifier = Modifier
                            .padding(8.dp),
                        style = Text14,
                        color = Grey50
                    )
                }
            }
        }
        if (!cocktail.strIngredient12.isNullOrEmpty()) {
            cocktail.strIngredient12?.let { name ->
                Box(
                    modifier = Modifier
                        .padding(start = 16.dp, top = 16.dp)
                        .border
                            (2.dp, color = Black1, RoundedCornerShape(8.dp))
                        .wrapContentSize()
                        .background(color = SoftBlueGray, shape = RoundedCornerShape(8.dp))
                        .clickable { actions.navigateToIngredientDetails(name) }
                ) {
                    Text(
                        text = name,
                        modifier = Modifier
                            .padding(8.dp),
                        style = Text14,
                        color = Black1
                    )
                }
            }
        }
        if (!cocktail.strIngredient13.isNullOrEmpty()) {
            cocktail.strIngredient13?.let { name ->
                Box(
                    modifier = Modifier
                        .padding(start = 16.dp, top = 16.dp)
                        .border
                            (2.dp, color = Black1, RoundedCornerShape(8.dp))
                        .wrapContentSize()
                        .background(color = PeriWinkle1, shape = RoundedCornerShape(8.dp))
                        .clickable { actions.navigateToIngredientDetails(name) }
                ) {
                    Text(
                        text = name,
                        modifier = Modifier
                            .padding(8.dp),
                        style = Text14,
                        color = Black1
                    )
                }
            }
        }
        if (!cocktail.strIngredient14.isNullOrEmpty()) {
            cocktail.strIngredient14?.let { name ->
                Box(
                    modifier = Modifier
                        .padding(start = 16.dp, top = 16.dp)
                        .border
                            (2.dp, color = Black1, RoundedCornerShape(8.dp))
                        .wrapContentSize()
                        .background(color = SkyBlue, shape = RoundedCornerShape(8.dp))
                        .clickable { actions.navigateToIngredientDetails(name) }
                ) {
                    Text(
                        text = name,
                        modifier = Modifier
                            .padding(8.dp),
                        style = Text14,
                        color = Black1
                    )
                }
            }
        }
    }
}


@Preview
@Composable
fun CocktailDetailPreview() {
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
            strIngredient2 = "Nice one",
            strIngredient3 = null,
            strIngredient4 = "124312412412",
            strIngredient5 = "123",
            strIngredient6 = "VODKA VODKA",
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
    CocktailDetailScreen(
        id = "17222",
        navController = rememberNavController(),
        modifier = Modifier
    )
}