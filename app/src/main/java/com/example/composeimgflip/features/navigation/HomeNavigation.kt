package com.example.composeimgflip.features.navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import com.example.composeimgflip.data.remote.Memes
import com.example.composeimgflip.features.screens.home.HomeScreenRoute
import com.google.accompanist.navigation.animation.composable

const val homeNavigationRoute = "home_route"

fun NavController.navigateToHome(
    navOptions: NavOptions? = null
) {
    this.navigate(homeNavigationRoute, navOptions)
}

@OptIn(ExperimentalAnimationApi::class)
fun NavGraphBuilder.homeScreen(
    navigateToDetail: (Memes) -> Unit
) {
    composable(route = homeNavigationRoute) {
        HomeScreenRoute(
            navigateToDetail = navigateToDetail
        )
    }
}