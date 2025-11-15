package com.example.local.model

import com.example.data.model.CategoryEntity


enum class CategoryLocal(val displayName: String) {
    COFFEE("Coffee"),
    ADE("Ade"),
    SMOOTHIE("Smoothie"),
    TEA("Tea")
}

fun CategoryLocal.toData(): CategoryEntity = CategoryEntity.valueOf(this.name)

fun CategoryEntity.toLocal(): CategoryLocal = CategoryLocal.valueOf(this.name)