package com.example.coctailcard.navigation.bottomnav

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.ui.theme.Black1
import com.example.ui.theme.Blue1
import com.example.ui.theme.Pink40
import com.example.ui.theme.Yellow1

@Composable
fun CocktailCenteredBottomButton(
    item: BottomNavItem
){
    Box(
        modifier = Modifier
            .size(width = 49.dp, height = 46.dp)
            .clip(RoundedCornerShape(topStartPercent = 50, topEndPercent = 50))
            .background(com.example.ui.theme.Black1),
        contentAlignment = Alignment.BottomCenter,
    ) {
        Card(
            modifier = Modifier
                .padding(bottom = 4.dp)
                .size(40.dp)
                .shadow(
                    elevation = 5.dp,
                    ambientColor = com.example.ui.theme.Yellow1,
                    spotColor = com.example.ui.theme.Yellow1,
                    shape = CircleShape,
                ),
            colors = CardDefaults.cardColors(
                containerColor = Color.White,
                contentColor = com.example.ui.theme.Black1
            ),
            shape = CircleShape,
        ) {
            Icon(
                painter = painterResource(id = item.icon),
                contentDescription = item.title,
                modifier = Modifier.align(Alignment.CenterHorizontally).padding(top = 5.dp, bottom = 3.dp)
            )
        }
    }
}

@Preview
@Composable
private fun PreviewComponent(){
    CocktailCenteredBottomButton(item = BottomNavItem.Cocktails)
}