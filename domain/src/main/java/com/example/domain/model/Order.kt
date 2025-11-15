package com.example.domain.model


data class Order (
    val id: Int,
    val price: Long,
    val items: List<MenuItem>
)
