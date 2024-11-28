package com.tomillis.home.domain.usecase

import com.tomillis.home.domain.TimeRepository

class DateUseCase (
    private val repo: TimeRepository
) {
    operator fun invoke(): String {
        return repo.getTimeZone()
    }
}