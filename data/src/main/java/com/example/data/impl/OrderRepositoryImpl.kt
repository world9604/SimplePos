package com.example.data.impl

import com.example.data.bound.flowDataResource
import com.example.data.local.OrderLocalDataSource
import com.example.data.model.toData
import com.example.domain.model.MenuItem
import kotlinx.coroutines.flow.Flow
import com.example.data_resource.DataResource
import com.example.domain.model.Order
import com.example.domain.repository.OrderRepository
import javax.inject.Inject

internal class OrderRepositoryImpl @Inject constructor(
    private val orderLocalDataSource: OrderLocalDataSource,
    //private val orderRemoteDataSource: OrderRemoteDataSource,
): OrderRepository {

    override suspend fun remove(id: Int) =
            orderLocalDataSource.remove(id)

    override fun getOrder(id: Int): Flow<DataResource<Order>> =
        flowDataResource { orderLocalDataSource.getOrderedMenu(id) }

    override suspend fun add(order: Order) =
        orderLocalDataSource.add(order.toData())

}
