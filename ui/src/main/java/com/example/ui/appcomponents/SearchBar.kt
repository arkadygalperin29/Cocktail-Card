package com.example.ui.appcomponents

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.LocalTextStyle
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ui.theme.Grey50
import com.example.ui.theme.Header1

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun SearchBar(onSearch: (String) -> Unit) {
    var searchQuery by remember { mutableStateOf("") }
    val keyboardController = LocalSoftwareKeyboardController.current

    Surface(
        color = MaterialTheme.colors.onSecondary,
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 8.dp, end = 16.dp, start = 16.dp)
            .border(2.dp, Grey50, RoundedCornerShape(16.dp)),
        shape = RoundedCornerShape(16.dp),

    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(top = 8.dp, end = 8.dp, start = 8.dp)
        ) {
            Icon(
                imageVector = Icons.Default.Search,
                modifier = Modifier.clickable {
                    onSearch(searchQuery)
                },
                contentDescription = null,
                tint = Color.Gray
            )
            Spacer(modifier = Modifier.width(8.dp))
            BasicTextField(
                value = searchQuery,
                onValueChange = { query ->
                    searchQuery = query.take(1)
                },
                keyboardOptions = KeyboardOptions.Default.copy(
                    imeAction = ImeAction.Search,
                    keyboardType = KeyboardType.Text
                ),
                keyboardActions = KeyboardActions(
                    onSearch = {
                        onSearch(searchQuery)
                        keyboardController?.hide() // Hide the keyboard when search is triggered
                    }
                ),
                textStyle = LocalTextStyle.current.copy(color = Grey50),
                modifier = Modifier
                    .weight(1f)
                    .padding(vertical = 8.dp)
            )
            Button(
                onClick = { onSearch(searchQuery) },
                modifier = Modifier
                    .padding(start = 8.dp, bottom = 6.dp),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = Grey50,
                    contentColor = Color.Black
                ),
                shape = RoundedCornerShape(8.dp)
            ) {
                Text(
                    "Search", color = Color.Black,
                    style = Header1, fontSize = 12.sp
                )
            }
        }
    }
}


@Preview
@Composable
fun SearchBarPreview() {
    SearchBar(onSearch = { })
}