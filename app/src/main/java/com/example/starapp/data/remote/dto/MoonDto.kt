package com.example.starapp.data.remote.dto

import kotlinx.serialization.Serializable

@Serializable
data class MoonDto(
    val moon: String? = null,
    val rel: String? = null,
)
