package com.example.presentation.menu

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.usecase.GetMenuItemsUseCase
import com.example.presentation.model.MenuItemModel
import com.example.presentation.model.toPresentation
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import com.example.data_resource.collectDataResource
import com.example.data_resource.mapListDataResource
import com.example.data_resource.mapDataResource
import com.example.data_resource.flatMapDataResource
import com.example.domain.usecase.AddToOrderUseCase
import com.example.domain.usecase.GetOrderUseCase
import com.example.presentation.model.toDomain
import javax.inject.Inject


@HiltViewModel
class MenuViewModel @Inject constructor(
    private val addToOrderUseCase: AddToOrderUseCase,
    private val getOrderUseCase: GetOrderUseCase,
    private val getMenuItemsUseCase: GetMenuItemsUseCase,
) : ViewModel() {

    private val CURRENT_ORDER_ID = 1

    private val _uiState = MutableStateFlow<MenuUiState>(MenuUiState.Loading)
    val uiState = _uiState.asStateFlow()

    init {
        loadMenuItems()
    }

    private fun loadMenuItems() {
        viewModelScope.launch {
            getMenuItemsUseCase()
                .mapListDataResource { it.toPresentation() }
                .flatMapDataResource { menuItems ->
                    //todo : orderId는 결제가 이루어 질 때마다, 값이 변경 되어야 함
                    getOrderUseCase(CURRENT_ORDER_ID)
                        .mapDataResource { order ->
                            menuItems to order.toPresentation()
                        }
                }
                .collectDataResource(
                    onSuccess = { (menuItems, order) ->
                        _uiState.update {
                            MenuUiState.Success(
                                menuItems = menuItems,
                                orderItems = order.items,
                                totalAmount = order.price
                            )
                        }
                    },
                    onError = { error ->
                        _uiState.update {
                            MenuUiState.Error(
                                message = error.message ?: "Unknown error occurred"
                            )
                        }
                    },
                    onLoading = {
                        _uiState.value = MenuUiState.Loading
                    }
                )
        }
    }

    /**
     * Add item to order with specified quantity
     */
    fun addToOrder(item: MenuItemModel) {
        viewModelScope.launch {
            try {
                addToOrderUseCase(CURRENT_ORDER_ID, item.toDomain())

                val currentState = _uiState.value
                if (currentState is MenuUiState.Success) {
                    val updatedOrder = getOrderUseCase(CURRENT_ORDER_ID)

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
    fun removeFromOrder(itemId: Int) {
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