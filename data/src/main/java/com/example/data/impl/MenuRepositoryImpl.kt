package com.example.data.impl

import com.example.data.local.MenuLocalDataSource
import com.example.data.remote.MenuRemoteDataSource
import com.example.domain.model.MenuItem
import com.example.domain.repository.MenuRepository
import kotlinx.coroutines.flow.Flow
import com.example.data_resource.DataResource
import javax.inject.Inject

internal class MenuRepositoryImpl @Inject constructor(
    private val menuLocalDataSource: MenuLocalDataSource,
    private val menuRemoteDataSource: MenuRemoteDataSource,
): MenuRepository {

    override fun getMenu(menuId: Int): MenuItem {
        TODO("Not yet implemented")
    }

    override fun getMenuItems(): Flow<DataResource<List<MenuItem>>> =
        flowDataResource { menuRemoteDataSource.getMenuItems() }
}
