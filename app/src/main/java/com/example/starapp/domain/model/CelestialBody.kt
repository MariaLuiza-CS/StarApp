package com.example.starapp.domain.model

data class CelestialBody(
    val id: String? = null,
    val name: String? = null,
    val englishName: String? = null,
    val isPlanet: Boolean? = null,
    val moons: List<Moon>? = null,
    val mass: Mass? = null,
    val gravity: Double? = null,
    val aroundPlanet: AroundPlanet? = null,
    val bodyType: String? = null,
)
