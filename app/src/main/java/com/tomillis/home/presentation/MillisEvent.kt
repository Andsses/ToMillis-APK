package com.tomillis.home.presentation

sealed interface MillisEvent {
    data class DayChange(val day: String) : MillisEvent
    data class MonthChange(val month: String) : MillisEvent
    data class YearChange(val year: String) : MillisEvent
}