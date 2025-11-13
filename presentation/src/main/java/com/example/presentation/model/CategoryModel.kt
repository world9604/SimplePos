package com.example.presentation.model

import com.example.domain.model.Category

enum class CategoryModel(val displayName: String) {
    COFFEE("Coffee"),
    ADE("Ade"),
    SMOOTHIE("Smoothie"),
    TEA("Tea")
}

fun Category.toPresentation(): CategoryModel = CategoryModel.valueOf(this.name)
