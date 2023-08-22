package com.example.ui.ingredients

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.domain.Ingredient
import com.example.ui.R
import com.example.ui.appcomponents.ZoomDialog
import com.example.ui.theme.Black1
import com.example.ui.theme.Brown1
import com.example.ui.theme.Grey50
import com.example.ui.theme.Header1
import com.example.ui.theme.Teal1
import com.example.ui.theme.Text14

@Composable
fun IngredientSingleCard(
    ingredient: Ingredient,
    drawableResId: Int,
    showZoomDialog: Boolean = false,
    setShowZoomDialog: (Boolean) -> Unit = { },
    description: String
) {
    if (showZoomDialog) {
        ZoomDialog(
            onDismissRequest = { setShowZoomDialog(false) },
            ingredient = Ingredient(
                ingredientName = ingredient.ingredientName,
                image = drawableResId, description = description
            )
        )
    }
    Card(
        modifier = Modifier
            .fillMaxSize()
            .border(4.dp, Black1, RoundedCornerShape(16.dp)),
        colors = CardDefaults.cardColors(
            containerColor = Teal1
        )
    ) {
        Box(modifier = Modifier
            .width(60.dp)
            .height(60.dp)
            .align(Alignment.End)
            .padding(top = 8.dp, end = 8.dp, bottom = 8.dp)
            .clip(shape = RoundedCornerShape(4.dp))
            .background(Color.Black.copy(alpha = 0.5f))
            .clickable { setShowZoomDialog(true) }) {
            Box(
                modifier = Modifier.fillMaxSize()
            ) {
                Image(
                    modifier = Modifier.align(Alignment.Center),
                    painter = painterResource(id = R.drawable.baseline_zoom_in_24),
                    contentDescription = "zoom icon",
                    contentScale = ContentScale.Crop
                )
            }
        }
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
                    color = Grey50,
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
                Box(
                    modifier = Modifier
                        .padding(8.dp)
                        .fillMaxWidth()
                        .border(3.dp, Grey50)
                        .background(Brown1)
                ) {
                    Text(
                        modifier = Modifier
                            .padding(8.dp),
                        text = description ?: "empty filler",
                        overflow = TextOverflow.Ellipsis,
                        style = Text14,
                        color = Grey50,
                        maxLines = 20
                    )
                }
            }

        }
    }
}

@Preview(apiLevel = 30)
@Composable
fun IngredientSingleCardPreview() {
    IngredientSingleCard(
        ingredient = Ingredient("Vodka", R.drawable.vodka, "Strong ruski vodka"),
        drawableResId = R.drawable.vodka,
        description = "some info"
    )
}
