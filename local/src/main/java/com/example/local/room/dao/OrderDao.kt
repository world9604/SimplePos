package com.example.local.room.dao

import androidx.room.Dao
import androidx.room.Query
import com.example.local.model.OrderLocal
import com.example.local.room.RoomConstant

@Dao
interface OrderDao : BaseDao<OrderLocal> {

    @Query("SELECT * FROM ${RoomConstant.Table.ORDER} WHERE id = :id")
    suspend fun getOrder(id: Int): OrderLocal?

    @Query("DELETE FROM ${RoomConstant.Table.ORDER} WHERE id = :id")
    suspend fun remove(id: Int)

}
