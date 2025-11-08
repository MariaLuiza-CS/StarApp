package com.example.starapp.data.remote.dto

import kotlinx.serialization.Serializable

@Serializable
data class AroundPlanetDto(
    val planet: String? = null,
    val rel: String? = null
)
