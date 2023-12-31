package com.example.ui.menu

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.domain.Cocktail
import com.example.ui.theme.Grey100
import com.example.ui.theme.Text12

@Composable
fun CocktailSingleCard(
    cocktail: Cocktail,
    onCocktailClicked: (String) -> Unit,
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(150.dp)
            .clip(shape = RoundedCornerShape(16.dp))
            .border(2.dp, com.example.ui.theme.Black1, RoundedCornerShape(16.dp))
            .clickable {
                onCocktailClicked(cocktail.id.toString())
            }
    ) {
        AsyncImage(
            modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth(0.45f)
                .background(color = Color.Black)
                .align(Alignment.BottomStart),
            model = cocktail.drinkImage,
            contentDescription = "Cocktail detail card",
            contentScale = ContentScale.Crop
        )
        Column(
            modifier = Modifier
                .padding()
                .align(Alignment.TopEnd)
        ) {
            if (!cocktail.name.isNullOrEmpty()) {
                cocktail.name?.let {
                    Text(
                        text = it,
                        modifier = Modifier
                            .fillMaxWidth(0.5f)
                            .padding(top = 16.dp),
                        maxLines = 4,
                        overflow = TextOverflow.Ellipsis,
                        style = Text12,
                        color = Grey100
                    )
                }
            }
            if (!cocktail.category.isNullOrEmpty()) {
                cocktail.category?.let {
                    Text(
                        text = it,
                        modifier = Modifier
                            .fillMaxWidth(0.5f)
                            .padding(top = 16.dp),
                        maxLines = 4,
                        overflow = TextOverflow.Ellipsis,
                        style = Text12,
                        color = Grey100
                    )
                }
            }
            if (!cocktail.alcoholic.isNullOrEmpty()) {
                cocktail.alcoholic?.let {
                    Text(
                        text = it,
                        modifier = Modifier
                            .fillMaxWidth(0.5f)
                            .padding(top = 16.dp),
                        maxLines = 4,
                        overflow = TextOverflow.Ellipsis,
                        style = Text12,
                        color = Grey100
                    )
                }
            }
            if (!cocktail.glass.isNullOrEmpty()) {
                cocktail.glass?.let {
                    Text(
                        text = it,
                        modifier = Modifier
                            .fillMaxWidth(0.5f)
                            .padding(top = 16.dp),
                        maxLines = 4,
                        overflow = TextOverflow.Ellipsis,
                        style = Text12,
                        color = Grey100
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun CocktailSingleCardPreview() {
    CocktailSingleCard(
        Cocktail(
            "1", "Daiquiry", "Alcoholic", "16%", "Margarita", "", "", "", "", "",
            "", "", "", "", "", "", "", "", "", "",
            ""
        ), {}
    )
}