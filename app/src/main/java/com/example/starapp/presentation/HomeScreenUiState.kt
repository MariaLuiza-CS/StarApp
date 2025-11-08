package com.example.starapp.presentation

import com.example.starapp.domain.model.CelestialBody

data class HomeScreenUiState(
    val isLoading: Boolean = false,
    val celestialBodies: List<CelestialBody> = emptyList(),
    val error: String? = null
)
