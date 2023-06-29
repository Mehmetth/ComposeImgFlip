package com.example.composeimgflip.data.repository

import com.example.composeimgflip.data.ImgFlipDataSource
import com.example.composeimgflip.data.remote.MemesResponse
import com.example.composeimgflip.data.remote.Resource
import com.example.composeimgflip.domain.repository.ImgFlipRepository
import kotlinx.coroutines.cancel
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import javax.inject.Inject

class ImgFlipRepositoryImpl @Inject constructor(
    private val imgFlipDataSource: ImgFlipDataSource
) : ImgFlipRepository {

    override fun getMemes(): Flow<Resource<MemesResponse>> =
        callbackFlow {
            val response = imgFlipDataSource.getMemes()
            if (response.isSuccessful) {
                response.body()?.let {
                    trySend(Resource.Success(it))
                } ?: kotlin.run {
                    trySend(Resource.Fail(null))
                }
            } else {
                trySend(Resource.Error(null))
            }
            awaitClose { cancel() }
        }
}