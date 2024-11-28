package com.tomillis.home.di

import com.tomillis.home.data.TimeRepositoryImpl
import com.tomillis.home.domain.TimeRepository
import com.tomillis.home.domain.usecase.DateUseCase
import com.tomillis.home.domain.usecase.NameZoneUseCase
import com.tomillis.home.domain.usecase.TimeUseCase
import com.tomillis.home.domain.usecase.UseCases
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun providesRepository(): TimeRepository{
        return TimeRepositoryImpl()
    }

    @Provides
    @Singleton
    fun provideUseCases(repository: TimeRepository): UseCases{
        return UseCases(
            timeUseCase = TimeUseCase(repository),
            dateUseCase = DateUseCase(repository),
            nameZoneUseCase = NameZoneUseCase(repository)
        )
    }
}