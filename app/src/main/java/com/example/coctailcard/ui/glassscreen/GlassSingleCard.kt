package com.example.coctailcard.ui.glassscreen

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
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.coctailcard.R
import com.example.coctailcard.data.network.models.Glass
import com.example.coctailcard.ui.theme.Black1
import com.example.coctailcard.ui.theme.Green1
import com.example.coctailcard.ui.theme.Grey100
import com.example.coctailcard.ui.theme.Grey1000
import com.example.coctailcard.ui.theme.Grey50
import com.example.coctailcard.ui.theme.Header1
import com.example.coctailcard.ui.theme.Pink40
import com.example.coctailcard.ui.theme.Pink80
import com.example.coctailcard.ui.theme.Text12

@Composable
fun GlassSingleCard(
    glass: Glass,
    onGlassClicked: (String) -> Unit,
    drawableResId: Int,
    description: String
) {
    Card(
        modifier = Modifier
            .fillMaxSize()
            .border(4.dp, Black1, RoundedCornerShape(16.dp))

    ) {
        Column(
            modifier = Modifier
                .padding(top = 8.dp)
                .fillMaxSize()
        ) {
            Text(
                text = glass.name,
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
                    .align(Alignment.CenterHorizontally),
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

@Preview
@Composable
fun GlassSingleCardPreview() {
    GlassSingleCard(
        glass = Glass(
            "Baloon glass",
            imageRes = R.drawable.balloon_glass,
            description = "Glass for some drinks"
        ),
        { },
        drawableResId = R.drawable.coupe_glass,
        description = "some info"
    )
}

