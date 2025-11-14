package com.example.presentation.model

import com.example.domain.model.MenuItem

data class MenuItemModel (
    val id: Int,
    val name: String,
    val quantity: Int,
    val price: Int,
    val category: CategoryModel,
    val imageUrl: String? = null
)

fun MenuItem.toPresentation(): MenuItemModel = MenuItemModel(
    id,
    name,
    quantity,
    price,
    category.toPresentation(),
    imageUrl
)