package com.example.coctailcard.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.ui.theme.Blue1
import com.example.ui.theme.Grey100
import com.example.ui.theme.Grey900
import com.example.ui.theme.Header2

@Composable
fun CategoryTabs(
    modifier: Modifier = Modifier,
    options: List<String>,
    selected: Int,
    selectedColor: ButtonColors = ButtonDefaults.buttonColors(
        containerColor = com.example.ui.theme.Blue1,
        contentColor = com.example.ui.theme.Grey100,
    ),
    unselectedColor: ButtonColors = ButtonDefaults.buttonColors(
        containerColor = Color.Transparent,
        contentColor = com.example.ui.theme.Grey100,
    ),
    onItemSelected: (Int) -> Unit
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .height(58.dp)
            .clip(RoundedCornerShape(8.dp))
            .background(com.example.ui.theme.Grey900)
            .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        options.forEachIndexed { index, option ->
            if (index > 0) Spacer(modifier = Modifier.width(24.dp))
            Button(
                modifier = Modifier
                    .height(42.dp)
                    .fillMaxWidth()
                    .weight(1f),
                onClick = { onItemSelected(index) },
                shape = RoundedCornerShape(8.dp),
                contentPadding = PaddingValues(0.dp),
                colors = if (index == selected) selectedColor else unselectedColor
            ) {
                Text(
                    modifier = Modifier
                        .align(Alignment.CenterVertically),
                    text = option,
                    textAlign = TextAlign.Center,
                    style = com.example.ui.theme.Header2,
                    maxLines = 1,
                )
            }
        }
    }
}


@Composable
@Preview
fun CategoryTabsPreview() {
    val selected = 0
    CategoryTabs(
        options = listOf("option 1", "option 2"),
        selected = selected,
        onItemSelected = { }
    )
}