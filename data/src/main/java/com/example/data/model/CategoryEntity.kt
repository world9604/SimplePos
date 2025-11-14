package com.example.data.model

import com.example.domain.model.Category


enum class CategoryEntity(val displayName: String) {
    COFFEE("Coffee"),
    ADE("Ade"),
    SMOOTHIE("Smoothie"),
    TEA("Tea")
}

fun Category.toData(): CategoryEntity = CategoryEntity.valueOf(this.name)