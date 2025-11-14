package com.example.remote.di

import com.example.data.remote.MenuRemoteDataSource
import com.example.remote.impl.MenuRemoteDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
internal abstract class RemoteDataSourceModule {

    @Binds
    @Singleton
    abstract fun bindMenuRemoteDataSource(source: MenuRemoteDataSourceImpl): MenuRemoteDataSource

}
