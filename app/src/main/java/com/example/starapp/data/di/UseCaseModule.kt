package com.example.starapp.data.di

import com.example.starapp.data.repository.PlanetRepository
import com.example.starapp.domain.usecase.GetAllBodiesUseCase
import com.example.starapp.domain.usecase.GetCelestialBodyById
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    @Provides
    @Singleton
    fun provideGetAllBodiesUseCase(repository: PlanetRepository) =
        GetAllBodiesUseCase(repository)

    @Provides
    @Singleton
    fun provideGetCelestialBodyById(repository: PlanetRepository) =
        GetCelestialBodyById(repository)
}
