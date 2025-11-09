package com.example.starapp.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.starapp.domain.usecase.GetAllBodiesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeScreenViewModel @Inject constructor(
    private val getAllBodiesUseCase: GetAllBodiesUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow(HomeScreenUiState())
    val uiState = _uiState.asStateFlow()

    fun onIntent(intent: HomeScreenIntent) {
        when (intent) {
            HomeScreenIntent.Load -> loadCelestialBodies()
        }
    }

    private fun loadCelestialBodies() {
        viewModelScope.launch {
            _uiState.value = _uiState.value.copy(
                isLoading = true,
                error = null
            )

            try {
                val celestialBodyList = getAllBodiesUseCase()
                _uiState.value = HomeScreenUiState(
                    isLoading = false,
                    celestialBodies = celestialBodyList
                )
            } catch (e: Exception) {
                _uiState.value = _uiState.value.copy(
                    isLoading = false,
                    error = e.message ?: "not know error"
                )
            }
        }
    }
}

sealed interface HomeScreenIntent {
    object Load : HomeScreenIntent
}