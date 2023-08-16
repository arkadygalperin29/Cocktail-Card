package com.example.coctailcard.ui.favorites

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
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
    deleteFavoriteCocktailClick: (String) -> Unit
) {
    Row(
        modifier = Modifier
            .height(150.dp)
            .fillMaxWidth(0.7f)
            .background(color = Black1)
            .clip(shape = RoundedCornerShape(16.dp))
            .border(2.dp, Black1, RoundedCornerShape(16.dp))
    ) {
        Column {
            if (!favoriteCocktail.name.isNullOrEmpty()) {
                favoriteCocktail.name?.let {
                    Text(
                        text = it,
                        modifier = Modifier
                            .padding(start = 8.dp, top = 16.dp, end = 16.dp),
                        maxLines = 4,
                        textAlign = TextAlign.Center,
                        overflow = TextOverflow.Ellipsis,
                        style = Text12,
                        color = Grey100,
                    )
                }
            }
            Image(
                painter = painterResource(id = R.drawable.delete_favorite),
                modifier = Modifier
                    .size(36.dp)
                    .clickable { deleteFavoriteCocktailClick(favoriteCocktail.id) }
                    .align(Alignment.Start)
                ,
                contentDescription = "delete favorite cocktail from database"
            )
        }
        AsyncImage(
            modifier = Modifier
                .fillMaxSize()
                .background(color = Color.Black)
                .clickable {
                    favoriteCocktailClick(favoriteCocktail.id)
                },
            model = favoriteCocktail.drinkImage,
            contentDescription = "Cocktail detail card",
            contentScale = ContentScale.Fit
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