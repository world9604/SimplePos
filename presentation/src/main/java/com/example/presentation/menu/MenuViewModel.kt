package com.example.presentation.menu

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.usecase.GetMenuItemsUseCase
import com.example.presentation.model.MenuItemModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MenuViewModel @Inject constructor(
    // TODO: Implement and inject UseCases
    private val addToOrderUseCase: AddToOrderUseCase,
    private val getOrderItemsUseCase: GetOrderItemsUseCase,
    private val getMenuItemsUseCase: GetMenuItemsUseCase,
    private val calculateTotalAmountUseCase: CalculateTotalAmountUseCase,
) : ViewModel() {

    private val _uiState = MutableStateFlow<MenuUiState>(MenuUiState.Loading)
    val uiState = _uiState.asStateFlow()

    init {
        loadMenuItems()
    }

    private fun loadMenuItems() {
        viewModelScope.launch {
            try {
                val updatedOrderItems = getMenuItemsUseCase()
                val newTotalAmount = calculateTotalAmountUseCase()

                _uiState.update {
                    MenuUiState.Success(
                        orderItems = updatedOrderItems,
                        totalAmount = newTotalAmount
                    )
                }
            } catch (e: Exception) {
                _uiState.update {
                    MenuUiState.Error(
                        message = e.message ?: "Unknown error occurred"
                    )
                }
            }
        }
    }

    /**
     * Add item to order with specified quantity
     */
    fun addToOrder(item: MenuItemModel) {
        viewModelScope.launch {
            try {
                addToOrderUseCase(item)

                val currentState = _uiState.value
                if (currentState is MenuUiState.Success) {
                    val updatedOrder = getOrderItemsUseCase()

                    _uiState.update {
                        currentState.copy(
                            orderItems = updatedOrder,
                        )
                    }
                }
            } catch (e: Exception) {
                _uiState.update {
                    MenuUiState.Error(
                        message = "Failed to add item to cart: ${e.message}"
                    )
                }
            }
        }
    }

    /**
     * Remove item from order
     */
    fun removeFromOrder(itemId: String) {
        viewModelScope.launch {
            try {
                val currentState = _uiState.value
                if (currentState is MenuUiState.Success) {
                    _uiState.update {
                        currentState.copy(
                            orderItems = currentState.orderItems
                                .filterNot { it.id == itemId }
                        )
                    }
                }
            } catch (e: Exception) {
                _uiState.update {
                    MenuUiState.Error(
                        message = "Failed to remove item: ${e.message}"
                    )
                }
            }
        }
    }

    /**
     * Clear all items from order
     */
    fun clearOrder() {
        val currentState = _uiState.value
        if (currentState is MenuUiState.Success) {
            _uiState.update {
                currentState.copy(
                    orderItems = emptyList(),
                )
            }
        }
    }

    /**
     * Retry loading when in error state
     */
    fun retry() {
        _uiState.update { MenuUiState.Loading }
        loadMenuItems()
    }
}