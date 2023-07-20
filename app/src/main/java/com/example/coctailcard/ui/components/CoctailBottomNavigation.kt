package com.example.coctailcard.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.coctailcard.navigation.rememberCoctailNavActions
import com.example.coctailcard.ui.components.bottomnav.AppKSKNavIcon
import com.example.coctailcard.ui.components.bottomnav.AppNavigationBarItem
import com.example.coctailcard.ui.components.bottomnav.BottomNavItem
import com.example.coctailcard.ui.theme.Black1
import com.example.coctailcard.ui.theme.Grey400
import com.example.coctailcard.ui.theme.Yellow1
import com.example.coctailcard.util.customShadow

@Composable
fun CoctailBottomNavigation(
    modifier: Modifier = Modifier,
    navController: NavController
) {
    val actions = rememberCoctailNavActions(navController)

    val items = listOf(
        BottomNavItem.Start,
        BottomNavItem.Offers,
        BottomNavItem.CardKSK,
        BottomNavItem.Stations,
        BottomNavItem.More
    )
    Box(
        modifier = modifier
            .height(63.dp),
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(49.dp)
                .customShadow(
                    color = Color(0, 0, 0, 0x0F),
                    offsetX = (-5).dp,
                    offsetY = (-5).dp,
                    blurRadius = 10.dp,
                ),
            colors = CardDefaults.cardColors(
                containerColor = Color.Transparent
            ),
            shape = RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp),
            content = { }
        )
        Box(
            contentAlignment = Alignment.BottomCenter
        ) {
            Box(
                modifier = Modifier
                    .padding(top = 14.dp)
                    .fillMaxWidth()
                    .height(83.dp)
                    .clip(RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp))
                    .background(Black1)
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp, end = 16.dp, bottom = 3.dp),
                verticalAlignment = Alignment.Bottom,
                horizontalArrangement = Arrangement.SpaceBetween,
            ) {
                items.forEach { item ->
                    AppNavigationBarItem(
                        selected = currentRoute == item.screenRoute,
                        onClick = {

                        },
                        selectedMarkerEnabled = item !is BottomNavItem.CardKSK,
                        icon = {
                            when (item) {
                                is BottomNavItem.CardKSK -> {
                                    AppKSKNavIcon(item = item)
                                }

                                else -> {
                                    Icon(
                                        modifier = Modifier.padding(bottom = 6.dp),
                                        painter = painterResource(id = item.icon),
                                        contentDescription = item.title,
                                        tint = if (currentRoute == item.screenRoute) Yellow1 else Grey400
                                    )
                                }
                            }
                        },
                        label = item.title
                    )
                }
            }
        }
    }
}
