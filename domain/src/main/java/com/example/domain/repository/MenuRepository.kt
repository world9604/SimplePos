package com.example.domain.repository

import com.example.domain.model.MenuItem
import kotlinx.coroutines.flow.Flow
import com.example.data_resource.DataResource

interface MenuRepository {

    fun getMenu(menuId: Int): Flow<DataResource<MenuItem>>

    fun getMenuItems(): Flow<DataResource<List<MenuItem>>>
}