package com.example.presentation.order

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class OrderViewModel @Inject constructor(
    private val addToCartUseCase: AddToCartUseCase,
    private val getMenuItemsUseCase: GetMenuItemsUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow(OrderUiState())
    val uiState = _uiState.asStateFlow()

    fun addToCart(item: MenuItem) {
        viewModelScope.launch {
            addToCartUseCase(item, 1)
            updateCartTotal()
        }
    }
}