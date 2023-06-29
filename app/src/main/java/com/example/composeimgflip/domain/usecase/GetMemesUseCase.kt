package com.example.composeimgflip.domain.usecase

import com.example.composeimgflip.data.remote.Memes
import com.example.composeimgflip.data.remote.Resource
import com.example.composeimgflip.domain.repository.ImgFlipRepository
import kotlinx.coroutines.cancel
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import javax.inject.Inject


class GetMemesUseCase @Inject constructor(
    private val imgFlipRepository: ImgFlipRepository
) {
    operator fun invoke(): Flow<GetMemesState> = callbackFlow {
        imgFlipRepository.getMemes().collect { result ->
            when (result) {
                is Resource.Success -> {
                    result.data?.let {
                        if (it.data.memes.isNotEmpty()) {
                            trySend(
                                GetMemesState.Data(it.data.memes)
                            )
                        } else {
                            trySend(
                                GetMemesState.EmptyData
                            )
                        }
                    } ?: kotlin.run {
                        trySend(
                            GetMemesState.EmptyData
                        )
                    }
                }

                is Resource.Error,
                is Resource.Fail -> {
                    trySend(GetMemesState.Error(result.message))
                }
            }
        }
        awaitClose { cancel() }
    }


    sealed interface GetMemesState {
        data class Data(val memes: List<Memes>) : GetMemesState
        data class Error(val throwable: Throwable?) : GetMemesState
        object EmptyData : GetMemesState
    }
}