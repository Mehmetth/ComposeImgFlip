package com.example.composeimgflip.features.screens.home

import com.example.composeimgflip.features.base.BaseViewModel
import com.example.composeimgflip.features.base.IEffect
import com.example.composeimgflip.features.base.IEvent
import com.example.composeimgflip.features.base.IState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class HomeViewModel @Inject constructor(
) : BaseViewModel<HomeState, HomeEvent, HomeEffect>() {

    override fun setInitialState() = HomeState(isLoading = false)

    override fun handleEvents(event: HomeEvent) {
        when (event) {
            else -> {}
        }
    }
}


data class HomeState(
    val isLoading: Boolean = false,
) : IState

sealed interface HomeEffect : IEffect {
    data class ShowError(val message: String) : HomeEffect

}

sealed interface HomeEvent : IEvent