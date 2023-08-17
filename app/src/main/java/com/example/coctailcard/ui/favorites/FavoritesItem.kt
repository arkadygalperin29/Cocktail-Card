package com.example.coctailcard.ui.favorites

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
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
import com.example.domain.Cocktail
import com.example.coctailcard.ui.theme.Black1
import com.example.coctailcard.ui.theme.SoftBlueGray
import com.example.coctailcard.ui.theme.TerraCotta
import com.example.coctailcard.ui.theme.Text12

@Composable
fun FavoriteCocktail(
    favoriteCocktail: com.example.domain.Cocktail,
    favoriteCocktailClick: (String) -> Unit,
    deleteFavoriteCocktailClick: (String) -> Unit
) {
    Row(
        modifier = Modifier
            .height(150.dp)
            .fillMaxWidth(0.8f)
            .clip(shape = RoundedCornerShape(16.dp))
            .background(color = Black1)
            .clip(shape = RoundedCornerShape(16.dp))
            .border(2.dp, Black1, RoundedCornerShape(16.dp))
    ) {
        Column {
            Box(
                modifier = Modifier
                    .padding(start = 16.dp, top = 16.dp)
                    .border
                        (2.dp, color = Black1, RoundedCornerShape(8.dp))
                    .wrapContentSize()
                    .background(color = SoftBlueGray, shape = RoundedCornerShape(8.dp))
            ) {
                if (!favoriteCocktail.name.isNullOrEmpty()) {
                    favoriteCocktail.name?.let {
                        Text(
                            text = it,
                            modifier = Modifier
                                .padding(start = 8.dp, top = 16.dp, end = 16.dp, bottom = 16.dp)
                                .clickable {
                                    favoriteCocktailClick(favoriteCocktail.id)
                                },
                            maxLines = 4,
                            textAlign = TextAlign.Center,
                            overflow = TextOverflow.Ellipsis,
                            style = Text12,
                            color = Black1,
                        )
                    }
                }
            }
            Box(
                modifier = Modifier
                    .padding(start = 16.dp, top = 16.dp)
                    .border
                        (2.dp, color = Black1, RoundedCornerShape(8.dp))
                    .wrapContentSize()
                    .clickable { deleteFavoriteCocktailClick(favoriteCocktail.id) }
                    .background(color = TerraCotta, shape = RoundedCornerShape(8.dp))
            ) {
                Image(
                    painter = painterResource(id = R.drawable.delete_favorite),
                    modifier = Modifier
                        .size(64.dp)
                        .padding(start = 8.dp, top = 16.dp, end = 16.dp)
                        .align(Alignment.Center),
                    contentDescription = "delete favorite cocktail from database"
                )
            }
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
        favoriteCocktail = com.example.domain.Cocktail(
            "", "Margarita", "", "", "", "",
            "", "", "", ""
        ), favoriteCocktailClick = { }, deleteFavoriteCocktailClick = { }
    )
}