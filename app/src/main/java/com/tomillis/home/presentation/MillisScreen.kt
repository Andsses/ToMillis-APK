package com.tomillis.home.presentation

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalClipboardManager
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.tomillis.home.presentation.components.ButtonsDateTime
import com.tomillis.home.presentation.components.CurrentTime
import com.tomillis.home.presentation.components.InputDateTime
import com.tomillis.home.presentation.components.TextDateTime

@Composable
fun MillisScreen(
    viewModel: MillisViewModel = hiltViewModel()
) {
    val state = viewModel.state
    val focusManager = LocalFocusManager.current
    val clipboardManager = LocalClipboardManager.current
    val context = LocalContext.current
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.Black)
            .pointerInput(Unit) {
                detectTapGestures(onTap = {
                    focusManager.clearFocus()
                })
            }
            .padding(20.dp),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(20.dp),
        ) {
            CurrentTime(state)
            if (state.resultHex.isNotEmpty() && state.resultMills.isNotEmpty()){
                TextDateTime(texto = "MILLS: ${state.resultMills}")
                TextDateTime(texto = "HEX: 0x${state.resultHex.uppercase()}L")
            } else {
                TextDateTime(texto = "Input Date Eg: 25-12-2030")
            }
            InputDateTime(state, viewModel::onEvent, focusManager)
            HorizontalDivider()
            ButtonsDateTime(text = "COPY MILLISECONDS", onAction = {
                if (state.resultMills.isNotEmpty()){
                    clipboardManager.setText(AnnotatedString(state.resultMills))
                }
            })
            ButtonsDateTime(text = "COPY HEX", onAction = {
                if (state.resultHex.isNotEmpty()){
                    clipboardManager.setText(AnnotatedString("0x${state.resultHex}L"))
                }
            })
        }
        Text(text = "By @x0andy", color = Color.White, modifier = Modifier
            .align(Alignment.BottomCenter)
            .padding(12.dp)
            .clickable {
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://t.me/tutoriales_apk"))
                context.startActivity(intent)
            })
    }
}

