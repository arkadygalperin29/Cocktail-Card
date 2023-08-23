package com.example.ui.offline

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.ui.R
import com.example.ui.theme.Grey50
import com.example.ui.theme.Header2
import com.example.ui.theme.Pink40

@Composable
fun OfflineScreen() {
    Column(
        modifier = Modifier
            .background(Pink40)
            .fillMaxSize()    ) {
        Text(
            modifier = Modifier
                .padding(top = 36.dp, start = 46.dp, end = 46.dp)
                .fillMaxWidth(),
            text = stringResource(R.string.no_internet_connection),
            style = Header2,
            color = Grey50,
            textAlign = TextAlign.Center
        )
        Text(
            modifier = Modifier
                .padding(top = 36.dp, start = 46.dp, end = 46.dp)
                .fillMaxWidth(),
            text = stringResource(R.string.restore_the_connection),
            style = Header2,
            color = Grey50,
            textAlign = TextAlign.Center
        )
        Image(
            modifier = Modifier
                .size(width = 203.dp, height = 170.dp)
                .padding(top = 53.dp, start = 50.dp)
                .align(alignment = Alignment.CenterHorizontally),
            painter = painterResource(id = R.drawable.check_internet_connection),
            contentDescription = null
        )
    }
}


@Preview
@Composable
fun OfflineScreenPreview() {
    OfflineScreen()
}