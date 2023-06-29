package com.example.composeimgflip.domain.repository

import com.example.composeimgflip.data.remote.MemesResponse
import com.example.composeimgflip.data.remote.Resource
import kotlinx.coroutines.flow.Flow

interface ImgFlipRepository {
    fun getMemes(): Flow<Resource<MemesResponse>>
}