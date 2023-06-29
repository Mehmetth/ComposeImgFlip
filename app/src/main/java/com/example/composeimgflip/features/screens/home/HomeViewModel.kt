package com.example.composeimgflip.features.screens.home

import androidx.lifecycle.viewModelScope
import com.example.composeimgflip.data.remote.Memes
import com.example.composeimgflip.domain.usecase.GetMemesUseCase
import com.example.composeimgflip.features.base.BaseViewModel
import com.example.composeimgflip.features.base.IEffect
import com.example.composeimgflip.features.base.IEvent
import com.example.composeimgflip.features.base.IState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getMemesUseCase: GetMemesUseCase
) : BaseViewModel<HomeState, HomeEvent, HomeEffect>() {

    init {
        getMemes()
    }

    override fun setInitialState() = HomeState()

    override fun handleEvents(event: HomeEvent) {
        when (event) {
            is HomeEvent.OnDetailClick -> setEffect {
                HomeEffect.NavigateToDetail(event.memes)
            }
        }
    }

    private fun getMemes() {
        viewModelScope.launch {
            getMemesUseCase.invoke().collect {
                when (it) {
                    is GetMemesUseCase.GetMemesState.Data -> {
                        setState(HomeState(isLoading = false, memes = it.memes))
                    }

                    GetMemesUseCase.GetMemesState.EmptyData -> {
                        setState(HomeState(isLoading = false, memes = emptyList()))
                    }

                    is GetMemesUseCase.GetMemesState.Error -> {
                        setState(HomeState(isLoading = false, memes = emptyList()))
                    }
                }
            }
        }
    }
}


data class HomeState(
    val isLoading: Boolean = true,
    val memes: List<Memes> = emptyList()
) : IState

sealed interface HomeEffect : IEffect {
    data class ShowError(val message: String) : HomeEffect
    data class NavigateToDetail(val memes: Memes) : HomeEffect
}

sealed interface HomeEvent : IEvent {
    data class OnDetailClick(val memes: Memes) :
        HomeEvent
}