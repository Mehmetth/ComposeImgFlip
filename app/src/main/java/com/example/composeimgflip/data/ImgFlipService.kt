package com.example.composeimgflip.data

import com.example.composeimgflip.data.remote.MemesResponse
import retrofit2.Response
import retrofit2.http.GET

interface ImgFlipService {
    @GET("get_memes")
    suspend fun getMemes(): Response<MemesResponse>
}