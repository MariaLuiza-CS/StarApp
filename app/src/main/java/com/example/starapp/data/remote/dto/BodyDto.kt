package com.example.starapp.data.remote.dto

import kotlinx.serialization.Serializable

@Serializable
data class BodyDto(
    val id: String? = null,
    val name: String? = null,
    val englishName: String? = null,
    val isPlanet: Boolean? = null,
    val moons: List<MoonDto>? = null,
    val mass: MassDto? = null,
    val gravity: Double? = null,
    val aroundPlanet: AroundPlanetDto? = null,
    val bodyType: String? = null,
)
