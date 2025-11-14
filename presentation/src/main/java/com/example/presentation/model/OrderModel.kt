package com.example.presentation.model

import com.example.domain.model.Order


data class OrderModel (
    val id: String,
    val price: Long,
    val items: List<MenuItemModel>
)

fun Order.toPresentation(): OrderModel = OrderModel(
    id,
    price,
    items.map { it.toPresentation() }
)
