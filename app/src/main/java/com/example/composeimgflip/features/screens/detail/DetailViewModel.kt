package com.example.composeimgflip.features.screens.detail

import androidx.lifecycle.SavedStateHandle
import com.example.composeimgflip.common.getDataFromJsonString
import com.example.composeimgflip.data.remote.Memes
import com.example.composeimgflip.features.base.BaseViewModel
import com.example.composeimgflip.features.base.IEffect
import com.example.composeimgflip.features.base.IEvent
import com.example.composeimgflip.features.base.IState
import com.example.composeimgflip.features.navigation.MemeDetailArgs
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle
) :
    BaseViewModel<DetailState, DetailEvent, DetailEffect>() {

    private val args = MemeDetailArgs(savedStateHandle)

    init {
        setState(DetailState(meme = getDataFromJsonString<Memes>(args.memeDetail)))
    }

    override fun setInitialState() = DetailState(isLoading = false)

    override fun handleEvents(event: DetailEvent) {
        when (event) {
            else -> {}
        }
    }
}


data class DetailState(
    val isLoading: Boolean = false,
    val meme: Memes? = null
) : IState

sealed interface DetailEffect : IEffect {
    data class ShowError(val message: String) : DetailEffect
}

sealed interface DetailEvent : IEvent