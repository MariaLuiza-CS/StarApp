package com.example.starapp.data.repository

import com.example.starapp.domain.model.CelestialBody

interface PlanetRepository {
    suspend fun getAllPlanets(): List<CelestialBody>
    suspend fun getPlanet(id: String): CelestialBody
}
