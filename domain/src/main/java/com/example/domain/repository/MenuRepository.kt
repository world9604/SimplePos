package com.example.domain.repository

import com.example.domain.model.MenuItem
import kotlinx.coroutines.flow.Flow

interface MenuRepository {

    fun getMenu(menuId: Int): MenuItem

    fun getMenuItems(): Flow<DataResource<List<MenuItem>>>
}