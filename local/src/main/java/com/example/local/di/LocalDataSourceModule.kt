package com.example.local.di

import com.example.data.local.MenuItemLocalDataSource
import com.example.data.local.OrderLocalDataSource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal abstract class LocalDataSourceModule {

    @Binds
    @Singleton
    abstract fun bindOrderLocalDataResource(source: OrderLocalDataSourceImpl): OrderLocalDataSource

    @Binds
    @Singleton
    abstract fun bindMenuItemLocalDataResource(source: MenuItemLocalDataSourceImpl): MenuItemLocalDataSource

}
