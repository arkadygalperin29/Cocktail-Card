package com.example.coctailcard.ui.theme

import androidx.compose.ui.graphics.Color

val Purple80 = Color(0xFFD0BCFF)
val PurpleGrey80 = Color(0xFFCCC2DC)
val Pink80 = Color(0xFFEFB8C8)

val Purple40 = Color(0xFF6650a4)
val PurpleGrey40 = Color(0xFF625b71)
val Pink40 = Color(0xFF7D5260)

val Grey1000 = Color(0xFF1F1F1F)
val Grey900 = Color(0xFF2C2C2C)
val Grey800 = Color(0xFF4C4C4C)
val Grey500 = Color(0xFF6D6D6D)
val Grey400 = Color(0xFF929292)
val Grey200 = Color(0xFFDADADA)
val Grey100 = Color(0xFFF5F5F5)
val Grey50 = Color(0xFFFCFCFC)
val Grey00 = Color(0xFFFFFFFF)
val Yellow1 = Color(0xFFFFD500)
val Yellow2 = Color(0xFFE3BE00)
val Green1 = Color(0xFF57BA47)
val Black1 = Color(0xFF000000)
val Red1 = Color(0xFFCE592C)
val RedClean = Color(0xFFFF0000)
val Blue1 = Color(0xFF3870B3)
val Blue2 = Color(0xFF6899D3)
val Purple1 = Color(0xFFCC33CC)


data class AppButtonColorsFilled(
    val containerColor: Color = Yellow1,
    val contentColor: Color = Grey1000,
    val disabledContainerColor: Color = Grey400,
    val disabledContentColor: Color = Grey800
)

data class AppButtonColorsOutlined(
    val containerColor: Color = Color.Transparent,
    val contentColor: Color = Yellow1,
    val disabledContainerColor: Color = Color.Transparent,
    val disabledContentColor: Color = Grey400
)