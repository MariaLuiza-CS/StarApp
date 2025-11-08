package com.example.starapp.domain.usecase

import com.example.starapp.data.repository.PlanetRepository
import com.example.starapp.domain.model.CelestialBody

class GetAllBodiesUseCase(private val repository: PlanetRepository) {

    suspend operator fun invoke(): List<CelestialBody> =
        repository.getAllPlanets()

}
