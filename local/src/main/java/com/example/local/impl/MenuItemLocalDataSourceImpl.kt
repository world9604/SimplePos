package com.example.local.impl

import com.example.data.local.MenuItemLocalDataSource
import com.example.data.model.MenuItemEntity
import com.example.local.model.toLocal
import com.example.local.room.dao.MenuItemDao
import javax.inject.Inject

class MenuItemLocalDataSourceImpl @Inject constructor(
    private val menuItemDao: MenuItemDao,
) : MenuItemLocalDataSource {

    override suspend fun add(menuItem: MenuItemEntity) =
        menuItemDao.insert(menuItem.toLocal())

    override suspend fun getMenuItem(menuId: Int): MenuItemEntity? =
        menuItemDao.getMenuItem(menuId)?.toData()

    override suspend fun getMenuItems(): List<MenuItemEntity>? =
        menuItemDao.getAllMenuItems()?.map { it.toData() }

    override suspend fun saveMenuItems(menus: List<MenuItemEntity>?) {
        menus?.map { it.toLocal() }?.let { menuItemDao.insertAll(it) }
    }
}