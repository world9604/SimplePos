package com.example.local.impl

import com.example.data.local.OrderLocalDataSource
import com.example.data.model.OrderEntity
import com.example.local.model.toLocal
import com.example.local.room.dao.OrderDao
import javax.inject.Inject

class OrderLocalDataSourceImpl @Inject constructor(
    private val orderDao: OrderDao,
) : OrderLocalDataSource {

    override suspend fun remove(id: Int) =
        orderDao.remove(id)

    override suspend fun getOrderedMenu(id: Int): OrderEntity? =
        orderDao.getOrder(id)?.toData()

    override suspend fun add(order: OrderEntity) =
        orderDao.insert(order.toLocal())
}