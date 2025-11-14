package com.example.domain.model


data class Order (
    val id: String,
    val price: Long,
    val items: List<MenuItem>
)
