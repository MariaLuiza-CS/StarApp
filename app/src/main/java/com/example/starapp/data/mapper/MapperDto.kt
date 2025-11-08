package com.example.starapp.data.mapper

import com.example.starapp.data.remote.dto.BodyDto
import com.example.starapp.domain.model.AroundPlanet
import com.example.starapp.domain.model.CelestialBody
import com.example.starapp.domain.model.Mass
import com.example.starapp.domain.model.Moon

fun BodyDto.toCelestialBody(): CelestialBody {
    return CelestialBody(
        id = id,
        name = name,
        englishName = englishName,
        isPlanet = isPlanet,
        gravity = gravity,
        moons = moons?.map { moonDto ->
            Moon(
                moon = moonDto.moon,
                rel = moonDto.rel
            )
        },
        mass = mass?.let {
            Mass(
                massValue = it.massValue,
                massExponent = it.massExponent
            )
        },
        aroundPlanet = aroundPlanet?.let {
            AroundPlanet(
                planet = it.planet,
                rel = it.rel
            )
        }
    )
}