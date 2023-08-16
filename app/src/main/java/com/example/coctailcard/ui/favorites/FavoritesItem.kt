package com.example.coctailcard.ui.favorites

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.coctailcard.R
import com.example.coctailcard.domain.models.Cocktail
import com.example.coctailcard.ui.theme.Black1
import com.example.coctailcard.ui.theme.Grey100
import com.example.coctailcard.ui.theme.Text12

@Composable
fun FavoriteCocktail(
    favoriteCocktail: Cocktail,
    favoriteCocktailClick: (String) -> Unit,
    deleteFavoriteCocktailClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .height(150.dp)
            .fillMaxWidth()
            .clip(shape = RoundedCornerShape(16.dp))
            .border(2.dp, Black1, RoundedCornerShape(16.dp))
            .clickable {
                favoriteCocktailClick(favoriteCocktail.id)
            }
    ) {
        if (!favoriteCocktail.name.isNullOrEmpty()) {
            favoriteCocktail.name?.let {
                Text(
                    text = it,
                    modifier = Modifier
                        .padding(start = 8.dp, top = 16.dp),
                    maxLines = 4,
                    textAlign = TextAlign.Center,
                    overflow = TextOverflow.Ellipsis,
                    style = Text12,
                    color = Grey100,
                )
            }
        }
        AsyncImage(
            modifier = Modifier
                .fillMaxSize()
                .background(color = Color.Black),
            model = favoriteCocktail.drinkImage,
            contentDescription = "Cocktail detail card",
            contentScale = ContentScale.Crop
        )
        Image(
            painter = painterResource(id = R.drawable.delete_favorite),
            modifier = Modifier.clickable { deleteFavoriteCocktailClick() },
            contentDescription = "delete favorite cocktail from database"
        )
    }
}

@Preview
@Composable
fun FavoriteCocktailPreview(

) {
    FavoriteCocktail(
        favoriteCocktail = Cocktail(
            "", "Margarita", "", "", "", "",
            "", "", "", ""
        ), favoriteCocktailClick = { }, deleteFavoriteCocktailClick = { }
    )
}