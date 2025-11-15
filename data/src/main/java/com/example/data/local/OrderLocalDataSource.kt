package com.example.data.local

import com.example.data.model.OrderEntity

interface OrderLocalDataSource {

    suspend fun remove(id: Int)

    suspend fun getOrderedMenu(id: Int): OrderEntity?

    suspend fun add(order: OrderEntity)
}
