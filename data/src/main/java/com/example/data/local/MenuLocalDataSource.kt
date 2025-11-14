package com.example.data.local

import com.example.data.model.MenuItemEntity

interface MenuLocalDataSource {

    suspend fun getMenuItem(menuId: Int): MenuItemEntity?
}