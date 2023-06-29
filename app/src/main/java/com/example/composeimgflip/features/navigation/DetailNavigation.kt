package com.example.composeimgflip.features.navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import com.example.composeimgflip.features.screens.detail.DetailScreenRoute
import com.google.accompanist.navigation.animation.composable

const val detailNavigationRoute = "detail_route"

fun NavController.navigateToMemeDetail(
    navOptions: NavOptions? = null
) {
    this.navigate(detailNavigationRoute, navOptions)
}

@OptIn(ExperimentalAnimationApi::class)
fun NavGraphBuilder.detailScreen() {
    composable(route = detailNavigationRoute) {
        DetailScreenRoute()
    }
}