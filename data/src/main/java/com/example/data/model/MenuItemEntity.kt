package com.example.data.model

import com.example.domain.model.MenuItem

data class MenuItemEntity (
    val id: Int,
    val name: String,
    val quantity: Int,
    val price: Int,
    val category: CategoryEntity,
    val imageUrl: String? = null
)

fun MenuItem.toData(): MenuItemEntity = MenuItemEntity(
    id,
    name,
    quantity,
    price,
    category.toData(),
    imageUrl
)