package com.example.coctailcard.ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import com.example.coctailcard.ui.components.scaffold.AppBottomBarType
import com.example.coctailcard.ui.components.scaffold.AppHeaderType
import com.example.coctailcard.ui.theme.Grey1000

@Composable
@OptIn(ExperimentalMaterial3Api::class, ExperimentalComposeUiApi::class)
fun CoctailScaffold(
    modifier: Modifier = Modifier,
    navController: NavController,
    topBarType: AppHeaderType = AppHeaderType.WithLogo(),
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
                            navController = navController
                        )
                    }

                    is AppHeaderType.WithLogoWithoutBell -> {
                        CoctailHeaderWithLogo(
                            logoAlignment = topBarType.logoAlignment,
                            navController = navController,
                            showFavoritesIcon = false
                        )
                    }

                    is AppHeaderType.WithButtons -> {
                        AppHeaderWithButtons(
                            name = topBarType.title,
                            onReturnClick = topBarType.onRetrunClick,
                            returnIcon = painterResource(id = topBarType.returnIconResId),
                            navController = navController
                        )
                    }

                    is AppHeaderType.None -> {
                        Box {}
                    }
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