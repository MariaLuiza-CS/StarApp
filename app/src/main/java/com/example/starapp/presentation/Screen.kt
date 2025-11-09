package com.example.starapp.presentation

sealed class Screen {
    data object Home : Screen()
    data object Carousel : Screen()
}