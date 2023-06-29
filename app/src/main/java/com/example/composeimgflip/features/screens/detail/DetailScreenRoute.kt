package com.example.composeimgflip.features.screens.detail

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.hilt.navigation.compose.hiltViewModel

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
            .background(Color.Red)
            .fillMaxSize()
    ) {
    }
}