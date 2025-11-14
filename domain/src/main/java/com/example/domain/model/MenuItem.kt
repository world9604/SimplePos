package com.example.domain.model

data class MenuItem(
    val id: String,
    val name: String,
    val quantity: Int,
    val price: Int,
    val category: Category,
    val imageUrl: String? = null
)