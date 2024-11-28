package com.tomillis.home.domain

interface TimeRepository {
    fun getCurrentTime(): String
    fun getTimeZone(): String
    fun getTimeNameZone(): String
}