package com.example.data.local

import com.example.data.model.MenuItemEntity

interface MenuItemLocalDataSource {

    suspend fun add(menuItem: MenuItemEntity)

    suspend fun getMenuItem(menuId: Int): MenuItemEntity?

    suspend fun getMenuItems(): List<MenuItemEntity>?

    suspend fun saveMenuItems(menus: List<MenuItemEntity>?)
}