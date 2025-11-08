package com.example.starapp.presentation

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.starapp.domain.model.CelestialBody

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    viewModel: HomeScreenViewModel,
    onBodyClick: (CelestialBody) -> Unit = {}
) {

    val state by viewModel.uiState.collectAsState()

    // Quando a tela entra, dispara o carregamento
    LaunchedEffect(Unit) {
        viewModel.onIntent(HomeScreenIntent.Load)
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Sistema Solar") }
            )
        }
    ) { padding ->
        Box(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize()
        ) {
            when {
                state.isLoading -> {
                    // Loading
                    CircularProgressIndicator(
                        modifier = Modifier.align(Alignment.Center)
                    )
                }

                state.error != null -> {
                    // Erro
                    Text(
                        text = "Erro: ${state.error}",
                        modifier = Modifier.align(Alignment.Center),
                        color = MaterialTheme.colorScheme.error
                    )
                }

                else -> {
                    // Lista de corpos
                    LazyColumn(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(16.dp),
                        verticalArrangement = Arrangement.spacedBy(12.dp)
                    ) {
                        items(
                            state.celestialBodies,
                            key = { it.id ?: it.name ?: it.englishName ?: "" }
                        ) { body ->
                            CelestialBodyItem(
                                body = body,
                                onClick = { onBodyClick(body) }
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun CelestialBodyItem(
    body: CelestialBody,
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() },
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = body.name ?: body.englishName ?: "Sem nome",
                style = MaterialTheme.typography.titleLarge
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(text = "Tipo: ${body.aroundPlanet ?: "Desconhecido"}")
            body.gravity?.let {
                Text(text = "Gravidade: %.2f m/s²".format(it))
            }
            Text(text = "É planeta: ${body.isPlanet}")
        }
    }
}