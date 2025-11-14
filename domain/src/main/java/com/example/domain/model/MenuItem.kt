package com.example.domain.model

data class MenuItem(
    val id: Int,
    val name: String,
    val quantity: Int,
    val price: Int,
    val category: Category,
    val imageUrl: String? = null
)