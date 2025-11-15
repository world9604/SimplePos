package com.example.domain.repository

import kotlinx.coroutines.flow.Flow
import com.example.data_resource.DataResource
import com.example.domain.model.Order

interface OrderRepository {

    suspend fun remove(id: Int)

    fun getOrder(id: Int): Flow<DataResource<Order>>

    suspend fun add(order: Order)
}