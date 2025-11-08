package com.example.starapp.domain.repository

import com.example.starapp.data.mapper.toCelestialBody
import com.example.starapp.data.remote.api.SolarSystemApi
import com.example.starapp.data.repository.PlanetRepository
import com.example.starapp.domain.model.CelestialBody

class PlanetRepositoryImpl(
    private val solarSystemApi: SolarSystemApi
) : PlanetRepository {
    override suspend fun getAllPlanets(): List<CelestialBody> {
        val response = solarSystemApi.getBodies()
        return response.bodies.map {
            it.toCelestialBody()
        }
    }

    override suspend fun getPlanet(id: String): CelestialBody {
        val response = solarSystemApi.getBody(id)
        return response.toCelestialBody()
    }
}
