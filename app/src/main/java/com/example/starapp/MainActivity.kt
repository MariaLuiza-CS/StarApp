package com.example.starapp

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.starapp.data.remote.network.NetworkModule
import com.example.starapp.domain.repository.PlanetRepositoryImpl
import com.example.starapp.domain.usecase.GetAllBodiesUseCase
import com.example.starapp.presentation.HomeScreen
import com.example.starapp.presentation.HomeScreenViewModel
import com.example.starapp.ui.theme.StarAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val api = NetworkModule.providerApi()
        val repository = PlanetRepositoryImpl(api)
        val getAllBodiesUseCase = GetAllBodiesUseCase(repository)
        val homeViewModel = HomeScreenViewModel(getAllBodiesUseCase)

        setContent {
            StarAppTheme {
                HomeScreen(
                    viewModel = homeViewModel,
                    onBodyClick = { Log.d("Teste", "testes") }
                )
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    StarAppTheme {
        Greeting("Android")
    }
}