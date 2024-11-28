package com.tomillis.home.data

import android.icu.util.TimeZone
import com.tomillis.home.domain.TimeRepository
import java.time.LocalDate
import java.time.LocalTime
import java.time.format.DateTimeFormatter
import javax.inject.Inject

class TimeRepositoryImpl @Inject constructor(): TimeRepository {
    override fun getCurrentTime(): String {
        return LocalTime.now().format(DateTimeFormatter.ofPattern("hh:mm:ss a"))
    }

    override fun getTimeZone(): String {
        return LocalDate.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"))
    }

    override fun getTimeNameZone(): String {
        return TimeZone.getDefault().displayName
    }
}