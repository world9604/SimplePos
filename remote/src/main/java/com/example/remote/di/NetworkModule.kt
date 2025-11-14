package com.example.remote.di

import com.example.remote.ApiService
import com.example.remote.api.createApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal object NetworkModule {

    @Provides
    @Singleton
    fun provideApiService(
        @Named("baseUrl") baseUrl: String,
    ): ApiService = createApiService(baseUrl)

}