package com.example.presentation.model

import com.example.domain.model.CartItem


data class CartItemModel (
    val item: MenuItemModel,
    val quantity: Int
)

fun CartItem.toPresentation(): CartItemModel = CartItemModel(
    item.toPresentation(),
    quantity
)