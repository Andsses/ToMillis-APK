package com.tomillis.home.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tomillis.home.domain.usecase.UseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.time.LocalDateTime
import java.time.ZoneOffset
import javax.inject.Inject
import kotlin.time.Duration.Companion.seconds

@HiltViewModel
class MillisViewModel @Inject constructor(
    private val usingCases: UseCases
) : ViewModel() {
    var state by mutableStateOf(MillisState())
        private set

    init {

        viewModelScope.launch {
            while (true) {
                state = state.copy(
                    timeCurrent = usingCases.timeUseCase(),
                    dateCurrent = usingCases.dateUseCase(),
                    nameZoneCurrent = usingCases.nameZoneUseCase()
                )
                delay(1.seconds)
                convert()
            }
        }
    }

    fun onEvent(event: MillisEvent) {
        when(event){
            is MillisEvent.DayChange -> {
                state = state.copy(
                    inputDay = event.day
                )
            }
            is MillisEvent.MonthChange -> {
                state = state.copy(
                    inputMonth = event.month
                )
            }
            is MillisEvent.YearChange -> {
                state = state.copy(
                    inputYear = event.year
                )
            }
        }
    }

    private fun convert(){
        if (state.inputDay.isNotEmpty() && state.inputMonth.isNotEmpty() && state.inputYear.isNotEmpty() && state.inputYear.length == 4){
            val resultToMillis = LocalDateTime.of(state.inputYear.toInt(), state.inputMonth.toInt(), state.inputDay.toInt(), 0, 0, 0, 0)
                .toInstant(ZoneOffset.UTC)
                .toEpochMilli()

            val resultToHex = resultToMillis.toString(16)

            state = state.copy(
                resultMills = resultToMillis.toString(),
                resultHex = resultToHex
            )
        }
    }
}