package com.example.starapp.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.starapp.R
import com.example.starapp.ui.theme.monaSansFont
import kotlinx.serialization.Serializable

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    navHostController: NavHostController,
    viewModel: HomeScreenViewModel = hiltViewModel()
) {

    val context = LocalContext
    val state by viewModel.uiState.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.onIntent(HomeScreenIntent.Load)
    }

    when {
        state.isLoading -> {
            Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                CircularProgressIndicator()
            }
        }

        state.error != null -> {
            Text(
                text = "Erro: ${state.error}",
                color = Color.Red,
                modifier = Modifier.padding(16.dp)
            )
        }

        else -> {
            Scaffold(
                topBar = {
                    TopAppBar(
                        title = {
                            Column(
                                Modifier
                                    .fillMaxWidth(),
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                Text(
                                    "Star App",
                                    fontFamily = monaSansFont,
                                    fontWeight = FontWeight.Medium,
                                    color = MaterialTheme.colorScheme.onBackground
                                )
                            }
                        },
                        colors = TopAppBarDefaults.topAppBarColors(
                            containerColor = MaterialTheme.colorScheme.secondary,

                        ),
                        modifier = Modifier
                            .clip(
                                RoundedCornerShape(
                                    bottomStart = 24.dp,
                                    bottomEnd = 24.dp
                                )
                            )
                    )
                },
                content = { paddingValues ->
                    Column(
                        modifier = Modifier
                            .padding(paddingValues)
                            .fillMaxSize()
                            .verticalScroll(rememberScrollState())
                            .background(MaterialTheme.colorScheme.onPrimary)
                    ) {
                        Column(
                            modifier = Modifier
                                .padding(20.dp)
                                .fillMaxSize()
                        ) {
                            Card(
                                colors = CardDefaults.cardColors(
                                    containerColor = MaterialTheme.colorScheme.primary
                                ),
                                elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
                                shape = RoundedCornerShape(12.dp),
                                modifier = Modifier.clickable {
                                    navHostController.navigate(DetailCarouselScreen)
                                }
                            ) {
                                Row(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(12.dp),
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    Image(
                                        painter = painterResource(id = R.drawable.img_moon),
                                        contentDescription = "",
                                        contentScale = ContentScale.Crop,
                                        modifier = Modifier
                                            .size(92.dp)
                                            .clip(RoundedCornerShape(10.dp))
                                    )

                                    Spacer(modifier = Modifier.width(12.dp))

                                    Column(
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .padding(end = 8.dp)
                                    ) {
                                        Text(
                                            text = "MOON",
                                            fontFamily = monaSansFont,
                                            fontWeight = FontWeight.Bold,
                                            color = MaterialTheme.colorScheme.background,
                                            fontSize = 14.sp,
                                            maxLines = 1
                                        )

                                        Spacer(modifier = Modifier.height(4.dp))

                                        Text(
                                            text = "Natural body that orbits a planet",
                                            fontFamily = monaSansFont,
                                            fontWeight = FontWeight.Medium,
                                            fontSize = 12.sp,
                                            color = MaterialTheme.colorScheme.background,
                                            lineHeight = 16.sp
                                        )
                                    }
                                }
                            }

                            Spacer(modifier = Modifier.height(12.dp))

                            Card(
                                colors = CardDefaults.cardColors(
                                    containerColor = MaterialTheme.colorScheme.primary
                                ),
                                elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
                                shape = RoundedCornerShape(12.dp),
                                modifier = Modifier.clickable {
                                    navHostController.navigate(DetailCarouselScreen)
                                }
                            ) {
                                Row(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(12.dp),
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    Image(
                                        painter = painterResource(id = R.drawable.img_earth),
                                        contentDescription = "",
                                        contentScale = ContentScale.Crop,
                                        modifier = Modifier
                                            .size(92.dp)
                                            .clip(RoundedCornerShape(10.dp))
                                    )

                                    Spacer(modifier = Modifier.width(12.dp))

                                    Column(
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .padding(end = 8.dp)
                                    ) {
                                        Text(
                                            text = "Planet",
                                            fontFamily = monaSansFont,
                                            fontWeight = FontWeight.Bold,
                                            color = MaterialTheme.colorScheme.background,
                                            fontSize = 14.sp,
                                            maxLines = 1
                                        )

                                        Spacer(modifier = Modifier.height(6.dp))

                                        Text(
                                            text = "Body orbiting a star, round, and clears its orbit",
                                            fontFamily = monaSansFont,
                                            fontWeight = FontWeight.Medium,
                                            fontSize = 12.sp,
                                            color = MaterialTheme.colorScheme.background,
                                            lineHeight = 16.sp
                                        )
                                    }
                                }
                            }

                            Spacer(modifier = Modifier.height(12.dp))

                            Card(
                                colors = CardDefaults.cardColors(
                                    containerColor = MaterialTheme.colorScheme.primary
                                ),
                                elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
                                shape = RoundedCornerShape(12.dp),
                                modifier = Modifier.clickable {
                                    navHostController.navigate(DetailCarouselScreen)
                                }
                            ) {
                                Row(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(12.dp),
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    Image(
                                        painter = painterResource(id = R.drawable.img_asteroid),
                                        contentDescription = "",
                                        contentScale = ContentScale.Crop,
                                        modifier = Modifier
                                            .size(92.dp)
                                            .clip(RoundedCornerShape(10.dp))
                                    )

                                    Spacer(modifier = Modifier.width(12.dp))

                                    Column(
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .padding(end = 8.dp)
                                    ) {
                                        Text(
                                            text = "Asteroid",
                                            fontFamily = monaSansFont,
                                            fontWeight = FontWeight.Bold,
                                            color = MaterialTheme.colorScheme.background,
                                            fontSize = 14.sp,
                                            maxLines = 1
                                        )

                                        Spacer(modifier = Modifier.height(6.dp))

                                        Text(
                                            text = "Rocky remnant from the early solar system",
                                            fontFamily = monaSansFont,
                                            fontWeight = FontWeight.Medium,
                                            fontSize = 12.sp,
                                            color = MaterialTheme.colorScheme.background,
                                            lineHeight = 16.sp
                                        )
                                    }
                                }
                            }

                            Spacer(modifier = Modifier.height(12.dp))

                            Card(
                                colors = CardDefaults.cardColors(
                                    containerColor = MaterialTheme.colorScheme.primary
                                ),
                                elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
                                shape = RoundedCornerShape(12.dp),
                                modifier = Modifier.clickable {
                                    navHostController.navigate(DetailCarouselScreen)
                                }
                            ) {
                                Row(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(12.dp),
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    Image(
                                        painter = painterResource(id = R.drawable.img_comet),
                                        contentDescription = "",
                                        contentScale = ContentScale.Crop,
                                        modifier = Modifier
                                            .size(92.dp)
                                            .clip(RoundedCornerShape(10.dp))
                                    )

                                    Spacer(modifier = Modifier.width(12.dp))

                                    Column(
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .padding(end = 8.dp)
                                    ) {
                                        Text(
                                            text = "Comet",
                                            fontFamily = monaSansFont,
                                            fontWeight = FontWeight.Bold,
                                            color = MaterialTheme.colorScheme.background,
                                            fontSize = 14.sp,
                                            maxLines = 1
                                        )

                                        Spacer(modifier = Modifier.height(6.dp))

                                        Text(
                                            text = "Icy body that forms a tail when near the Sun",
                                            fontFamily = monaSansFont,
                                            fontWeight = FontWeight.Medium,
                                            fontSize = 12.sp,
                                            color = MaterialTheme.colorScheme.background,
                                            lineHeight = 16.sp
                                        )
                                    }
                                }
                            }

                            Spacer(modifier = Modifier.height(12.dp))

                            Card(
                                colors = CardDefaults.cardColors(
                                    containerColor = MaterialTheme.colorScheme.primary
                                ),
                                elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
                                shape = RoundedCornerShape(12.dp),
                                modifier = Modifier.clickable {
                                    navHostController.navigate(DetailCarouselScreen)
                                }
                            ) {
                                Row(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(12.dp),
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    Image(
                                        painter = painterResource(id = R.drawable.img_dwarf_planet),
                                        contentDescription = "",
                                        contentScale = ContentScale.Crop,
                                        modifier = Modifier
                                            .size(92.dp)
                                            .clip(RoundedCornerShape(10.dp))
                                    )

                                    Spacer(modifier = Modifier.width(12.dp))

                                    Column(
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .padding(end = 8.dp)
                                    ) {
                                        Text(
                                            text = "Dwarf Planet",
                                            fontFamily = monaSansFont,
                                            fontWeight = FontWeight.Bold,
                                            color = MaterialTheme.colorScheme.background,
                                            fontSize = 14.sp,
                                            maxLines = 1
                                        )

                                        Spacer(modifier = Modifier.height(6.dp))

                                        Text(
                                            text = "Round body orbiting the Sun but not clearing its orbit",
                                            fontFamily = monaSansFont,
                                            fontWeight = FontWeight.Medium,
                                            fontSize = 12.sp,
                                            color = MaterialTheme.colorScheme.background,
                                            lineHeight = 16.sp
                                        )
                                    }
                                }
                            }

                            Spacer(modifier = Modifier.height(12.dp))

                            Card(
                                colors = CardDefaults.cardColors(
                                    containerColor = MaterialTheme.colorScheme.primary
                                ),
                                elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
                                shape = RoundedCornerShape(12.dp),
                                modifier = Modifier.clickable {
                                    navHostController.navigate(DetailCarouselScreen)
                                }
                            ) {
                                Row(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(12.dp),
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    Image(
                                        painter = painterResource(id = R.drawable.img_sun),
                                        contentDescription = "",
                                        contentScale = ContentScale.Crop,
                                        modifier = Modifier
                                            .size(92.dp)
                                            .clip(RoundedCornerShape(10.dp))
                                    )

                                    Spacer(modifier = Modifier.width(12.dp))

                                    Column(
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .padding(end = 8.dp)
                                    ) {
                                        Text(
                                            text = "Star",
                                            fontFamily = monaSansFont,
                                            fontWeight = FontWeight.Bold,
                                            color = MaterialTheme.colorScheme.background,
                                            fontSize = 14.sp,
                                            maxLines = 1
                                        )

                                        Spacer(modifier = Modifier.height(6.dp))

                                        Text(
                                            text = "Giant ball of hot gas producing light and heat",
                                            fontFamily = monaSansFont,
                                            fontWeight = FontWeight.Medium,
                                            fontSize = 12.sp,
                                            color = MaterialTheme.colorScheme.background,
                                            lineHeight = 16.sp
                                        )
                                    }
                                }
                            }
                        }
                    }
                }
            )
        }
    }
}

@Serializable
object HomeScreen