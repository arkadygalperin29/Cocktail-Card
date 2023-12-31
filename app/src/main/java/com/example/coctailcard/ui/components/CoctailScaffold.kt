package com.example.coctailcard.ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import com.example.coctailcard.ui.components.scaffold.AppBottomBarType
import com.example.coctailcard.ui.components.scaffold.AppHeaderType
import com.example.ui.theme.Grey1000

@Composable
fun CoctailScaffold(
    modifier: Modifier = Modifier,
    navController: NavController,
    topBarType: AppHeaderType? = AppHeaderType.WithLogo(onRetrunClick = { }),
    bottomBarType: AppBottomBarType = AppBottomBarType.Normal,
    contentColor: Color = LocalContentColor.current,
    containerColor: Color = Color.Transparent,
    content: @Composable (PaddingValues) -> Unit
) {
    Scaffold(
        modifier = modifier.then(
            Modifier
                .systemBarsPadding()
                .imePadding()
        ),
        topBar = {
            CompositionLocalProvider(LocalContentColor provides Grey1000) {
                when (topBarType) {
                    is AppHeaderType.WithLogo -> {
                        CoctailHeaderWithLogo(
                            logoAlignment = topBarType.logoAlignment,
                            navController = navController,
                            onReturnClick = topBarType.onRetrunClick,
                            returnIcon = painterResource(id = topBarType.returnIconResId)
                        )
                    }

                    is AppHeaderType.WithLogoWithoutFavorites -> {
                        CoctailHeaderWithLogo(
                            logoAlignment = topBarType.logoAlignment,
                            navController = navController,
                            showFavoritesIcon = false,
                            onReturnClick = {}
                        )
                    }

                    is AppHeaderType.WithButtons -> {
                        AppHeaderWithButtons(
                            name = topBarType.title ?: "",
                            onReturnClick = topBarType.onRetrunClick,
                            returnIcon = painterResource(id = topBarType.returnIconResId),
                            navController = navController
                        )
                    }

                    is AppHeaderType.None -> {
                        Box {}
                    }

                    else -> {}
                }
            }
        },
        bottomBar = {
            when (bottomBarType) {
                is AppBottomBarType.Normal -> {
                        CoctailBottomNavigation(
                            modifier = Modifier.wrapContentHeight(),
                            navController = navController
                        )
                }
                is AppBottomBarType.None -> {
                    Box {}
                }
            }
        },
        contentColor = contentColor,
        containerColor = containerColor,
    ) {
        content(it)
    }
}