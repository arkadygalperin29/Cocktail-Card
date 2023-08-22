package com.example.ui.appcomponents

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.rememberTransformableState
import androidx.compose.foundation.gestures.transformable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.example.domain.Ingredient
import com.example.ui.R

@Composable
fun ZoomDialog(
    onDismissRequest: () -> Unit,
    ingredient: Ingredient
) {
    var scale by remember { mutableFloatStateOf(2.5f) }
    var rotation by remember { mutableFloatStateOf(1f) }
    var offset by remember { mutableStateOf(Offset.Zero) }
    val state = rememberTransformableState { zoomChange, offsetChange, rotationChange ->
        scale *= zoomChange
        rotation += rotationChange
        offset += offsetChange
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center
    ) {
        Dialog(onDismissRequest = { onDismissRequest() }) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 38.dp, start = 64.dp)
            ) {
                Box(
                    modifier = Modifier
                        .width(60.dp)
                        .height(60.dp)
                        .align(Alignment.End)
                        .clip(shape = RoundedCornerShape(4.dp))
                        .background(Color.Black.copy(alpha = 0.5f))
                        .clickable { onDismissRequest() }
                ) {
                    Image(
                        modifier = Modifier
                            .align(Alignment.Center),
                        painter = painterResource(id = R.drawable.baseline_chevron_left_24),
                        contentDescription = "zoom icon",
                        contentScale = ContentScale.Crop
                    )
                }
                Image(
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                        .padding(top = 110.dp, bottom = 36.dp)
                        .graphicsLayer(
                            scaleX = maxOf(0.5f, minOf(scale)),
                            scaleY = maxOf(0.5f, minOf(scale)),
                            rotationZ = rotation,
                            translationX = offset.x,
                            translationY = offset.y
                        )
                        .transformable(state)
                        .size(160.dp),
                    alignment = Alignment.Center,
                    painter = painterResource(id = ingredient.image ?: R.drawable.absolut_citron),
                    contentDescription = null,
                )
            }
        }
    }
}

@Preview
@Composable
fun ZoomDialogPreview() {
    ZoomDialog(
        onDismissRequest = { },
        ingredient = Ingredient("vodka", R.drawable.absolut_citron, "123")
    )
}