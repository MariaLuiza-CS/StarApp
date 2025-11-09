package com.example.starapp

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.starapp.presentation.DetailCarouselScreen
import com.example.starapp.presentation.HomeScreen

@Composable
fun StarAppNavGraph(
    navHostController: NavHostController,
    startDestination: Any
) {
    NavHost(
        navController = navHostController,
        startDestination = startDestination
    ) {
        composable<HomeScreen> {
            HomeScreen(
                navHostController = navHostController
            )
        }
        composable<DetailCarouselScreen> {
            DetailCarouselScreen(
                navHostController = navHostController
            )
        }
    }
}
