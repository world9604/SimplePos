package com.example.presentation.menu

import com.example.presentation.model.MenuItemModel


sealed interface MenuUiState {

    data object Loading : MenuUiState

    data class Success(
        val menuItems: List<MenuItemModel> = emptyList(),
        val orderItems: List<MenuItemModel> = emptyList(),
        val totalAmount: Long = 0L
    ) : MenuUiState

    data class Error(
        val message: String
    ) : MenuUiState
}
