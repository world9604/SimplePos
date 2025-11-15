package com.example.local.di

import android.content.Context
import androidx.room.Room
import com.example.local.room.AppDatabase
import com.example.local.room.RoomConstant
import com.example.local.room.dao.MenuItemDao
import com.example.local.room.dao.OrderDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal object LocalRoomModule {

    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext context: Context): AppDatabase =
        Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            RoomConstant.ROOM_DB_NAME
        )
            .fallbackToDestructiveMigration()
            .build()

    @Provides
    @Singleton
    fun provideOrderDao(database: AppDatabase): OrderDao = database.orderDao()

    @Provides
    @Singleton
    fun provideMenuItemDao(database: AppDatabase): MenuItemDao = database.menuItemDao()
}
