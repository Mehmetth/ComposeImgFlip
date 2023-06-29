package com.example.composeimgflip.features.navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.Composable
import com.example.composeimgflip.common.toJson
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.rememberAnimatedNavController


@OptIn(ExperimentalAnimationApi::class)
@Composable
fun NavGraph() {
    val navController = rememberAnimatedNavController()

    AnimatedNavHost(
        navController = navController,
        startDestination = homeNavigationRoute,
    ) {
        homeScreen(navigateToDetail = {
            navController.navigateToMemeDetail(it.toJson())
        })
        detailScreen()
    }
}