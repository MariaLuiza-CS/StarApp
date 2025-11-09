package com.example.starapp.presentation

import androidx.compose.animation.core.FastOutLinearInEasing
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.starapp.domain.model.CelestialBody
import kotlinx.serialization.Serializable
import kotlin.math.absoluteValue

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailCarouselScreen(
    navHostController: NavHostController
) {
    val mockBodies = listOf(
        CelestialBody(name = "Mercúrio", englishName = "Mercury"),
        CelestialBody(name = "Vênus", englishName = "Venus"),
        CelestialBody(name = "Terra", englishName = "Earth"),
        CelestialBody(name = "Marte", englishName = "Mars"),
        CelestialBody(name = "Júpiter", englishName = "Jupiter")
    )

    val pagerState = rememberPagerState(pageCount = { mockBodies.size })

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Carrossel de Corpos Celestes") }
            )
        }
    ) { padding ->
        HorizontalPager(
            state = pagerState,
            modifier = Modifier
                .fillMaxSize()
                .padding(padding),
            contentPadding = PaddingValues(horizontal = 64.dp)
        ) { page ->
            val pageOffset = (
                    (pagerState.currentPage - page) + pagerState.currentPageOffsetFraction
                    ).absoluteValue

            val targetScale = 1f - (pageOffset * 0.25f)
            val targetAlpha = 1f - (pageOffset * 0.5f)
            val targetElevation = 12.dp * (1f - pageOffset)

            // ⚡ Animação mais rápida e responsiva
            val animatedScale by animateFloatAsState(
                targetValue = targetScale.coerceIn(0.85f, 1f),
                animationSpec = tween(durationMillis = 250, easing = FastOutLinearInEasing)
            )
            val animatedAlpha by animateFloatAsState(
                targetValue = targetAlpha.coerceIn(0.6f, 1f),
                animationSpec = tween(durationMillis = 250, easing = LinearOutSlowInEasing)
            )
            val animatedElevation by animateDpAsState(
                targetValue = targetElevation.coerceIn(2.dp, 12.dp),
                animationSpec = tween(durationMillis = 250, easing = FastOutLinearInEasing)
            )

            CarouselCard(
                body = mockBodies[page],
                scale = animatedScale,
                alpha = animatedAlpha,
                elevation = animatedElevation
            )
        }
    }
}

@Composable
fun CarouselCard(
    body: CelestialBody,
    scale: Float,
    alpha: Float,
    elevation: Dp
) {
    Card(
        modifier = Modifier
            .graphicsLayer {
                scaleX = scale
                scaleY = scale
                this.alpha = alpha
            }
            .fillMaxWidth()
            .height(400.dp)
            .padding(16.dp),
        shape = RoundedCornerShape(28.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = elevation)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = body.englishName ?: "Desconhecido",
                style = MaterialTheme.typography.headlineLarge
            )
            Spacer(Modifier.height(8.dp))
            Text(
                text = "Um corpo celeste fascinante!",
                style = MaterialTheme.typography.bodyLarge
            )
        }
    }
}

@Serializable
object DetailCarouselScreen