package com.example.ui.category

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.domain.Cocktail
import com.example.ui.theme.Black1
import com.example.ui.theme.Grey100
import com.example.ui.theme.Text12

@Composable
fun AlcoholicDrink(
    alcoholicCocktail: Cocktail,
    alcoholicCocktailClick: (String) -> Unit
) {
    Column(
        modifier = Modifier
            .height(250.dp)
            .fillMaxWidth(0.5f)
            .clip(shape = RoundedCornerShape(16.dp))
            .border(2.dp, Black1, RoundedCornerShape(16.dp))
            .clickable {
                alcoholicCocktailClick(alcoholicCocktail.id)
            }
    ) {
        if (!alcoholicCocktail.name.isNullOrEmpty()) {
            alcoholicCocktail.name?.let {
                Text(
                    text = it,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 8.dp, top = 16.dp),
                    maxLines = 4,
                    textAlign = TextAlign.Center,
                    overflow = TextOverflow.Ellipsis,
                    style = Text12,
                    color = Grey100,
                )
            }
            AsyncImage(
                modifier = Modifier
                    .fillMaxSize()
                    .background(color = Color.Black),
                model = alcoholicCocktail.drinkImage,
                contentDescription = "Cocktail detail card",
                contentScale = ContentScale.Crop
            )
        }
    }
}

@Preview
@Composable
fun AlcoholicDrinkPreview() {
    AlcoholicDrink(Cocktail("Margharita", "", ""), { })
}