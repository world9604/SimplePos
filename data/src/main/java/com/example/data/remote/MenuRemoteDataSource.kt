package com.example.data.remote

import com.example.data.model.MenuItemEntity

interface MenuRemoteDataSource {

    suspend fun getMenuItem(menuId: Int): MenuItemEntity

    suspend fun getMenuItems(): List<MenuItemEntity>
}