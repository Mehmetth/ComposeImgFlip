package com.example.composeimgflip.data

import javax.inject.Inject

class ImgFlipDataSource @Inject constructor(
    private val imgFlipService: ImgFlipService
) {
    suspend fun getMemes() = imgFlipService.getMemes()
}