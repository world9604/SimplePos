package com.example.ui.order

import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.Column
import com.example.presentation.order.OrderViewModel

@Composable
fun OrderScreen(
    viewModel: OrderViewModel = hiltViewModel()
) {
    val uiState by viewModel.uiState.collectAsState()

    Column {
        MenuGrid(
            items = uiState.menuItems,
            onItemClick = viewModel::addToCart
        )

        CartSummary(
            items = uiState.cartItems,
            total = uiState.totalAmount
        )
    }
}