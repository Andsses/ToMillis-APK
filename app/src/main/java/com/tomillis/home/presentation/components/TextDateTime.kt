package com.tomillis.home.presentation.components

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
fun TextDateTime(
    texto : String,
    color : Color = Color.White,
    modifier: Modifier = Modifier
) {
    Text(text = texto , color = color, modifier = modifier)
}