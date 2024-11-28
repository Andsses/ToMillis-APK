package com.tomillis.home.presentation.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.focus.FocusManager
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.core.text.isDigitsOnly
import com.tomillis.home.presentation.MillisEvent
import com.tomillis.home.presentation.MillisState
import com.tomillis.ui.theme.ColorFive
import com.tomillis.ui.theme.ColorFour
import com.tomillis.ui.theme.ColorThree

@Composable
fun InputDateTime(
    state: MillisState,
    onEvent: (MillisEvent) -> Unit,
    focusManager: FocusManager,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(20.dp),
        horizontalArrangement = Arrangement.spacedBy(20.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        TextField(
            value = state.inputDay, onValueChange = { input ->
                if (input.isDigitsOnly() && input.length <= 2) {
                    if ((input.isEmpty()) || (input.toIntOrNull() in 1..31)) {
                        onEvent(MillisEvent.DayChange(input))
                        if (input.length == 2){
                            focusManager.moveFocus(FocusDirection.Next)
                        }
                    }
                }
            },
            modifier = modifier
                .weight(1f)
                .border(
                    border = BorderStroke(
                        width = 2.dp, brush = Brush.horizontalGradient(
                            colors = listOf(ColorFive, ColorFour, ColorThree),
                            startX = 0f,
                            endX = Float.POSITIVE_INFINITY
                        )
                    )
                ),
            colors = TextFieldDefaults.colors(
                unfocusedContainerColor = Color.Black,
                focusedContainerColor = Color.Black,
                focusedTextColor = Color.White,
                unfocusedTextColor = Color.White
            ),
            keyboardActions = KeyboardActions(
                onNext = { focusManager.moveFocus(FocusDirection.Next) }
            ),
            keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Next, keyboardType = KeyboardType.Number),
            placeholder = { Text(text = "Day") },
            maxLines = 1,
        )
        TextField(
            value = state.inputMonth, onValueChange = { input ->
                if (input.isDigitsOnly() && input.length <= 2) {
                    if ((input.isEmpty()) || (input.toIntOrNull() in 1..12 || input.isEmpty())) {
                        onEvent(MillisEvent.MonthChange(input))
                        if (input.length == 2){
                            focusManager.moveFocus(FocusDirection.Next)
                        }
                    }
                }
            },
            modifier = modifier
                .weight(1f)
                .border(
                    border = BorderStroke(
                        width = 2.dp, brush = Brush.horizontalGradient(
                            colors = listOf(ColorFive, ColorFour, ColorThree),
                            startX = 0f,
                            endX = Float.POSITIVE_INFINITY
                        )
                    )
                ),
            colors = TextFieldDefaults.colors(
                unfocusedContainerColor = Color.Black,
                focusedContainerColor = Color.Black,
                focusedTextColor = Color.White,
                unfocusedTextColor = Color.White
            ),
            keyboardActions = KeyboardActions(
                onNext = { focusManager.moveFocus(FocusDirection.Next) }
            ),
            keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Next, keyboardType = KeyboardType.Number),
            placeholder = { Text(text = "Month") },
            maxLines = 1,
        )
        TextField(
            value = state.inputYear, onValueChange = { input ->
                if (input.isDigitsOnly() && input.length <= 4) {
                    if ((input.isEmpty()) || (input.toIntOrNull() in 1..9999)) {
                        onEvent(MillisEvent.YearChange(input))
                        if (input.length == 4){
                            focusManager.clearFocus()
                        }
                    }
                }
            },
            modifier = modifier
                .weight(1f)
                .border(
                    border = BorderStroke(
                        width = 2.dp, brush = Brush.horizontalGradient(
                            colors = listOf(ColorFive, ColorFour, ColorThree),
                            startX = 0f,
                            endX = Float.POSITIVE_INFINITY
                        )
                    )
                ),
            colors = TextFieldDefaults.colors(
                unfocusedContainerColor = Color.Black,
                focusedContainerColor = Color.Black,
                focusedTextColor = Color.White,
                unfocusedTextColor = Color.White
            ),
            keyboardActions = KeyboardActions(
                onDone = { focusManager.clearFocus() }
            ),
            keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.Done, keyboardType = KeyboardType.Number),
            placeholder = { Text(text = "Year") },
            maxLines = 1,
        )
    }
}