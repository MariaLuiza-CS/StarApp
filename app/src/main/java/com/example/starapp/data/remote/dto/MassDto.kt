package com.example.starapp.data.remote.dto

import kotlinx.serialization.Serializable

@Serializable
data class MassDto(
    val massValue: Double? = null,
    val massExponent: Double? = null
)
