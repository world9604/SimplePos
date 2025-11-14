package com.example.remote.impl

import com.example.data.model.MenuItemEntity
import com.example.data.remote.MenuRemoteDataSource
import com.example.remote.ApiService
import javax.inject.Inject

class MenuRemoteDataSourceImpl @Inject constructor(
    private val apiService: ApiService,
) : MenuRemoteDataSource {

    private val language = "KO-KR"
    private val country = "korea"

    companion object {
        private const val YOUTUBE = "YouTube"
        private const val TRAILER = "Trailer"
    }

    override suspend fun getMenuItem(menuId: Int): MenuItemEntity {
        TODO("Not yet implemented")
    }

    override suspend fun getMenuItems(): List<MenuItemEntity> =
        apiService.getSummaryMovies(language, country).summaryMovies.map { it.toData() }

}
