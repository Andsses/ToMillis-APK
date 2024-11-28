package com.tomillis.home.presentation.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun ButtonsDateTime(
    text : String,
    onAction : () -> Unit,
    modifier: Modifier = Modifier
){
    Button(onClick = { onAction() }, modifier = modifier.fillMaxWidth()) {
        Text(text = text)
    }
}