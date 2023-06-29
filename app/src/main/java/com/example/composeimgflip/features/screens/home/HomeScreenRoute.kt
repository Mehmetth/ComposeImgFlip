package com.example.composeimgflip.features.screens.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.hilt.navigation.compose.hiltViewModel


@Composable
fun HomeScreenRoute(
    viewModel: HomeViewModel = hiltViewModel()
) {
    val viewState = viewModel.state.collectAsState().value

    LaunchedEffect(viewModel.effect) {
        viewModel.effect.collect { effect ->
            when (effect) {
                is HomeEffect.ShowError -> Unit
            }
        }
    }

    HomeScreen(
        viewState,
        onViewEvent = viewModel::setEvent
    )
}

@Composable
private fun HomeScreen(
    viewState: HomeState,
    onViewEvent: (HomeEvent) -> Unit,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Blue)
    ) {
    }
}