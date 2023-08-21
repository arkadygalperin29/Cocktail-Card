package com.example.ui.appcomponents

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.ui.R

@Preview
@Composable
fun AppLoader() {
    Dialog(onDismissRequest = { }) {
        Box(modifier = Modifier.fillMaxSize()) {

            AsyncImage(
                modifier = Modifier
                    .align(Alignment.Center)
                    .padding(bottom = 90.dp)
                    .size(64.dp),
                model = ImageRequest
                    .Builder(LocalContext.current)
                    .data(R.drawable.loader)
                    .build(),
                contentDescription = null
            )
        }
    }
}