package com.example.starapp.data.di

import com.example.starapp.data.remote.api.SolarSystemApi
import com.example.starapp.data.repository.PlanetRepository
import com.example.starapp.domain.repository.PlanetRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun providePlanetRepository(solarSystemApi: SolarSystemApi): PlanetRepository =
        PlanetRepositoryImpl(solarSystemApi)
}
