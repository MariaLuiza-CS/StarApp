package com.example.starapp.data.remote.dto

import kotlinx.serialization.Serializable

@Serializable
data class BodiesResponseDto(
    val bodies: List<BodyDto> = emptyList()
)
