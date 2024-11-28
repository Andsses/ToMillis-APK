package com.tomillis.home.presentation.components

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.tomillis.home.presentation.MillisState
import com.tomillis.ui.theme.ColorFive
import com.tomillis.ui.theme.ColorFour
import com.tomillis.ui.theme.ColorThree

@Composable
fun CurrentTime(
    state: MillisState,

    modifier: Modifier = Modifier
) {
    Surface(
        modifier = modifier.fillMaxWidth(), color = Color.Black,
        border = BorderStroke(
            width = 2.dp, brush = Brush.horizontalGradient(
                colors = listOf(ColorFive, ColorFour, ColorThree),
                startX = 0f,
                endX = Float.POSITIVE_INFINITY
            )
        )
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = modifier.padding(12.dp)
        ) {
            Text(text = "Today: ${state.dateCurrent} ${state.timeCurrent.uppercase()}", color = Color.White)
            Text(text = state.nameZoneCurrent, color = Color.White)
        }
    }
}