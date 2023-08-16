package com.example.coctailcard.ui.components

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.coctailcard.R
import com.example.coctailcard.domain.models.Cocktail
import com.example.coctailcard.domain.models.CocktailMain
import com.example.coctailcard.navigation.rememberCocktailNavActions
import com.example.coctailcard.ui.detailscreens.CocktailDetailViewModel
import com.example.coctailcard.ui.theme.Black1
import com.example.coctailcard.ui.theme.Grey00
import com.example.coctailcard.ui.theme.Yellow1
import org.koin.androidx.compose.koinViewModel
import kotlin.math.absoluteValue

@Composable
fun CoctailHeaderWithLogo(
    logoAlignment: Alignment.Horizontal = Alignment.CenterHorizontally,
    navController: NavController,
    showFavoritesIcon: Boolean = true,
    viewModel: CocktailDetailViewModel = koinViewModel()
) {
    val state by viewModel.state.collectAsState()
    val actions = rememberCocktailNavActions(navController = navController)

    Box(
        modifier = Modifier
            .height(44.dp)
            .fillMaxWidth()
            .background(Black1),
    ) {
        Image(
            modifier = Modifier
                .let {
                    when (logoAlignment) {
                        Alignment.CenterHorizontally -> it.align(Alignment.BottomCenter)
                        Alignment.Start -> it.align(Alignment.BottomStart)
                        else -> it.align(Alignment.BottomCenter)
                    }
                }
                .padding(start = 16.dp, end = 16.dp, bottom = 12.dp)
                .width(127.dp)
                .height(19.dp),
            contentScale = ContentScale.Fit,
            painter = painterResource(R.drawable.empty_glass_icon),
            contentDescription = "logo"
        )
        if (showFavoritesIcon) {
            Box(
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .padding(end = 16.dp, bottom = 8.dp)
                    .size(24.dp)
                    .clickable {
                        viewModel.insertFavorite(favoriteCocktail = state.cocktail ?: Cocktail())
                        Log.d("Element is recorded", "23123 ${state.cocktail?.id} ")
                        //                      actions.navigateToHome()
                    }
            ) {
                Icon(
                    modifier = Modifier
                        .size(24.dp),
                    imageVector = Icons.Outlined.Favorite,
                    contentDescription = null,
                    tint = Grey00
                )
            }
        }
        Divider(
            modifier = Modifier.align(Alignment.BottomCenter),
            thickness = 2.dp,
            color = Yellow1
        )
    }
}

