package com.example.local.room.dao

import androidx.room.Dao
import androidx.room.Query
import com.example.local.model.MenuItemLocal
import com.example.local.room.RoomConstant

@Dao
interface MenuItemDao : BaseDao<MenuItemLocal> {

    @Query("DELETE FROM ${RoomConstant.Table.MENU_ITEM} WHERE id = :id")
    suspend fun remove(id: Int)

    @Query("SELECT * FROM ${RoomConstant.Table.MENU_ITEM} WHERE id = :id")
    suspend fun getMenuItem(id: Int): MenuItemLocal?

    @Query("SELECT * FROM ${RoomConstant.Table.MENU_ITEM}")
    suspend fun getAllMenuItems(): List<MenuItemLocal>?

}
