package com.example.composeimgflip.app.di

import com.example.composeimgflip.data.ImgFlipDataSource
import com.example.composeimgflip.data.ImgFlipService
import com.example.composeimgflip.data.repository.ImgFlipRepositoryImpl
import com.example.composeimgflip.domain.repository.ImgFlipRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideImgFlipDataSource(
        imgFlipService: ImgFlipService,
    ): ImgFlipDataSource = ImgFlipDataSource(imgFlipService)

    @Provides
    @Singleton
    fun provideImgFlipRepository(
        imgFlipDataSource: ImgFlipDataSource,
    ): ImgFlipRepository = ImgFlipRepositoryImpl(imgFlipDataSource)

}