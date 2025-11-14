package com.example.simplepos.di

import android.app.Application
import com.example.simplepos.SimplePosApplication
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Named

@Module
@InstallIn(SingletonComponent::class)
internal object AppModule {

    @Provides
    @Named("baseUrl")
    fun provideBaseUrl(application: Application): String =
        (application as SimplePosApplication).baseUrl

}