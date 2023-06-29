package com.example.composeimgflip.features.screens.detail

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.example.composeimgflip.features.component.shimmerBrush

@Composable
fun DetailScreenRoute(
    viewModel: DetailViewModel = hiltViewModel(),
) {
    val viewState = viewModel.state.collectAsState().value

    DetailScreen(
        viewState,
        onViewEvent = viewModel::setEvent
    )
}

@Composable
private fun DetailScreen(
    viewState: DetailState,
    onViewEvent: (DetailEvent) -> Unit,
) {
    Box(
        Modifier
            .background(Color.Black)
            .fillMaxSize()
    ) {
        val showShimmer = remember { mutableStateOf(true) }
        AsyncImage(
            model = viewState.meme?.url,
            contentDescription = "",
            contentScale = ContentScale.FillWidth,
            onSuccess = {
                showShimmer.value = false
            },
            modifier = Modifier
                .fillMaxSize()
        )
    }
}