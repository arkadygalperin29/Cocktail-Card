package com.example.coctailcard.ui.glassscreen

import androidx.compose.foundation.Image
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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.coctailcard.R
import com.example.coctailcard.data.network.models.Glass
import com.example.coctailcard.ui.theme.Black1
import com.example.coctailcard.ui.theme.Grey50

@Composable
fun GlassSingleCard(
    glass: Glass,
    onGlassClicked: (String) -> Unit,
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(150.dp)
            .border(2.dp, Black1, RoundedCornerShape(16.dp))
            .clickable {
                onGlassClicked(glass.name.toString())
            }
            .background(color = Grey50)
    ) {
        Image(
            modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth(0.45f)
                .align(Alignment.BottomStart),
            painter = painterResource(id = glass.imageRes ?: R.drawable.balloon_glass),
            contentDescription = "Cocktail detail card",
            contentScale = ContentScale.Fit
        )
        Column(
            modifier = Modifier
                .align(Alignment.TopCenter)
                .padding(start = 32.dp, top = 8.dp)
        ) {
            Text(text = glass.name)
            glass.description?.let { Text(text = it) }
        }
    }
}

@Preview
@Composable
fun GlassSingleCardPreview() {
    GlassSingleCard(
        glass = Glass(
            "Baloon glass",
            imageRes = R.drawable.balloon_glass,
            description = "Glass for some drinks"
        ), { })
}

