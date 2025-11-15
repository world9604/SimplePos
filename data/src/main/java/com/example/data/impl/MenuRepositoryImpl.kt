package com.example.data.impl

import com.example.data.bound.flowDataResource
import com.example.data.local.MenuItemLocalDataSource
import com.example.data.remote.MenuRemoteDataSource
import com.example.domain.model.MenuItem
import com.example.domain.repository.MenuRepository
import kotlinx.coroutines.flow.Flow
import com.example.data_resource.DataResource
import javax.inject.Inject

internal class MenuRepositoryImpl @Inject constructor(
    private val menuItemLocalDataSource: MenuItemLocalDataSource,
    private val menuRemoteDataSource: MenuRemoteDataSource,
): MenuRepository {

    override fun getMenu(menuId: Int): Flow<DataResource<MenuItem>> =
        flowDataResource { menuItemLocalDataSource.getMenuItem(menuId) }

    override fun getMenuItems(): Flow<DataResource<List<MenuItem>>> =
        flowDataResource (
            { menuRemoteDataSource.getMenuItems() },
            { menuItemLocalDataSource.getMenuItems() },
            { menuItemLocalDataSource.saveMenuItems(it) }
        )
}
