package com.example.data.model

import com.example.domain.model.Category
import com.example.domain.model.MenuItem

data class MenuItemEntity (
    val id: String,
    val name: String,
    val quantity: Int,
    val price: Int,
    val category: Category,
    val imageUrl: String? = null
)

fun MenuItem.toData(): MenuItemEntity = MenuItemEntity(
    id,
    name,
    quantity,
    price,
    category,
    imageUrl
)