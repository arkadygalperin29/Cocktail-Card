package com.example.coctailcard.ui.category

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.coctailcard.data.network.models.NonAlcoholicCocktail
import com.example.coctailcard.ui.theme.Blue1
import com.example.coctailcard.ui.theme.Grey100
import com.example.coctailcard.ui.theme.Text12

@Composable
fun NonAlcoholicDrink(
    nonAlcoholicCocktail: NonAlcoholicCocktail,
    nonAlcoholicCocktailClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .height(250.dp)
            .fillMaxWidth(0.5f)
            .background(color = Blue1)
            .clickable {
                nonAlcoholicCocktailClick()
            }
    ) {
        Text(
            text = nonAlcoholicCocktail.name,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 8.dp, top = 16.dp)
                .align(Alignment.CenterHorizontally),
            maxLines = 4,
            textAlign = TextAlign.Center,
            overflow = TextOverflow.Ellipsis,
            style = Text12,
            color = Grey100,
        )
        AsyncImage(
            modifier = Modifier
                .fillMaxSize()
                .background(color = Color.Black)
                .align(Alignment.CenterHorizontally),
            model = nonAlcoholicCocktail.image,
            contentDescription = "Cocktail detail card",
            contentScale = ContentScale.Fit
        )

    }
}


@Preview
@Composable
fun NonAlcoholicDrinkPreview() {
    NonAlcoholicDrink(NonAlcoholicCocktail("Daiquiry", "", ""), { })
}