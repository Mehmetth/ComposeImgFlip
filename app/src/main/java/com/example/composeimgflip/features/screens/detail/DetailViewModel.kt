package com.example.composeimgflip.features.screens.detail

import com.example.composeimgflip.features.base.BaseViewModel
import com.example.composeimgflip.features.base.IEffect
import com.example.composeimgflip.features.base.IEvent
import com.example.composeimgflip.features.base.IState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor() :
    BaseViewModel<DetailState, DetailEvent, DetailEffect>() {

    override fun setInitialState() = DetailState(isLoading = false)

    override fun handleEvents(event: DetailEvent) {
        when (event) {
            else -> {}
        }
    }
}


data class DetailState(
    val isLoading: Boolean = false
) : IState

sealed interface DetailEffect : IEffect {
    data class ShowError(val message: String) : DetailEffect
}

sealed interface DetailEvent : IEvent