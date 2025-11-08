package com.example.starapp.domain.usecase

import com.example.starapp.data.repository.PlanetRepository
import com.example.starapp.domain.model.CelestialBody

class GetCelestialBodyById(private val planetRepository: PlanetRepository) {

    suspend operator fun invoke(id: String): CelestialBody =
        planetRepository.getPlanet(id)

}
