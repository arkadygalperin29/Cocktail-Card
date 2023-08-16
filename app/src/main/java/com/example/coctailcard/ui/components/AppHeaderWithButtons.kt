package com.example.coctailcard.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.coctailcard.R
import com.example.coctailcard.navigation.rememberCocktailNavActions
import com.example.coctailcard.ui.theme.Black1
import com.example.coctailcard.ui.theme.Grey00
import com.example.coctailcard.ui.theme.Header1

@Composable
fun AppHeaderWithButtons(
    name: String,
    onReturnClick: () -> Unit,
    returnIcon: Painter = painterResource(id = R.drawable.baseline_chevron_left_24),
    navController: NavController,
) {
    val actions = rememberCocktailNavActions(navController = navController)

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .height(44.dp)
            .background(Black1),
        verticalArrangement = Arrangement.Bottom,
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, end = 16.dp, bottom = 6.dp),
            verticalAlignment = Alignment.Bottom,
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            Row(
                modifier = Modifier
                    .height(24.dp)
                    .wrapContentWidth()
                    .clickable { onReturnClick() },
                verticalAlignment = Alignment.Top,
            ) {
                Icon(
                    modifier = Modifier
                        .padding(end = 10.dp),
                    painter = returnIcon,
                    contentDescription = stringResource(R.string.label_return),
                    tint = Grey00
                )
                Text(
                    modifier = Modifier.padding(bottom = 3.dp),
                    text = name,
                    style = Header1,
                    color = Grey00,
                )
            }
        }
        Divider(
            thickness = 2.dp,
            color = Color.White
        )
    }
}

@Preview
@Composable
fun PreviewAppHeaderWithButtons() {
    AppHeaderWithButtons(
        name = "Header name",
        onReturnClick = { },
        navController = rememberNavController(),
    )
}

@Preview
@Composable
fun PreviewAppHeaderWithButtonsNoSave() {
    AppHeaderWithButtons(
        name = "Header name",
        onReturnClick = { },
        navController = rememberNavController(),
    )
}