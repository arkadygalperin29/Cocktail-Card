package com.example.coctailcard.ui.ingredients

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.coctailcard.R
import com.example.coctailcard.data.network.models.Ingredient
import com.example.coctailcard.ui.theme.Black1
import com.example.coctailcard.ui.theme.Grey1000
import com.example.coctailcard.ui.theme.Grey50
import com.example.coctailcard.ui.theme.Header1
import com.example.coctailcard.ui.theme.Text12

@Composable
fun IngredientSingleCard(
    ingredient: Ingredient,
    drawableResId: Int,
    description: String
) {
    Card(
        modifier = Modifier
            .fillMaxSize()
            .border(4.dp, Black1, RoundedCornerShape(16.dp))
            .background(color = Grey50)
    ) {
        Box {
            Column(
                modifier = Modifier
                    .padding(top = 8.dp)
                    .fillMaxSize()
            ) {
                Text(
                    text = ingredient.ingredientName,
                    modifier = Modifier
                        .padding(start = 8.dp)
                        .align(Alignment.CenterHorizontally),
                    overflow = TextOverflow.Ellipsis,
                    style = Header1,
                    color = Grey1000,
                )
                Image(
                    modifier = Modifier
                        .fillMaxHeight(0.5f)
                        .fillMaxWidth(0.5f)
                        .align(Alignment.CenterHorizontally)
                        .border(4.dp, Black1),
                    painter = painterResource(id = drawableResId ?: R.drawable.balloon_glass),
                    contentDescription = "Cocktail detail card",
                    contentScale = ContentScale.Crop
                )
                Text(
                    modifier = Modifier
                        .padding(8.dp)
                        .fillMaxWidth(),
                    text = description ?: "empty filler",
                    overflow = TextOverflow.Ellipsis,
                    style = Text12,
                    color = Grey1000,
                    maxLines = 20
                )
            }

        }
    }
}

@Preview
@Composable
fun IngredientSingleCardPreview() {
    IngredientSingleCard(ingredient = Ingredient("Vodka", R.drawable.vodka, "Strong ruski vodka"),
        drawableResId = R.drawable.vodka,
        description = "some info")
}
