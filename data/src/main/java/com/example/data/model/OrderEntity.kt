package com.example.data.model

import com.example.domain.model.Order

data class OrderEntity (
    val id: Int,
    val price: Long,
    val items: List<MenuItemEntity>
)

fun Order.toData(): OrderEntity = OrderEntity(
    id,
    price,
    items.map { it.toData() }
)