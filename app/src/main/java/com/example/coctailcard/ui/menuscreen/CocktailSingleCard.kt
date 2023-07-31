package com.example.coctailcard.ui.menuscreen

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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage
import com.example.coctailcard.data.network.models.Cocktail
import com.example.coctailcard.navigation.rememberCocktailNavActions
import com.example.coctailcard.ui.theme.Black1
import com.example.coctailcard.ui.theme.Grey100
import com.example.coctailcard.ui.theme.Text12

@Composable
fun CocktailSingleCard(
    cocktail: Cocktail,
    onCocktailClicked: (String) -> Unit,
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(150.dp)
            .border(2.dp, Black1, RoundedCornerShape(16.dp))
            .clickable {
                onCocktailClicked(cocktail.id)
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
                Text(
                    text = cocktail.name,
                    modifier = Modifier
                        .fillMaxWidth(0.5f)
                        .padding(top = 16.dp),
                    maxLines = 4,
                    overflow = TextOverflow.Ellipsis,
                    style = Text12,
                    color = Grey100
                )
            }
            if (!cocktail.category.isNullOrEmpty()) {
                Text(
                    text = cocktail.category,
                    modifier = Modifier
                        .fillMaxWidth(0.5f)
                        .padding(top = 16.dp),
                    maxLines = 4,
                    overflow = TextOverflow.Ellipsis,
                    style = Text12,
                    color = Grey100
                )
            }
            if (!cocktail.alcoholic.isNullOrEmpty()) {
                Text(
                    text = cocktail.alcoholic,
                    modifier = Modifier
                        .fillMaxWidth(0.5f)
                        .padding(top = 16.dp),
                    maxLines = 4,
                    overflow = TextOverflow.Ellipsis,
                    style = Text12,
                    color = Grey100
                )
            }
            if (!cocktail.glass.isNullOrEmpty()) {
                Text(
                    text = cocktail.glass,
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