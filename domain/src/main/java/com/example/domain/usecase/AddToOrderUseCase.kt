package com.example.domain.usecase

import com.example.data_resource.DataResource
import com.example.domain.model.MenuItem
import com.example.domain.repository.OrderRepository
import kotlinx.coroutines.flow.first
import javax.inject.Inject

class AddToOrderUseCase @Inject constructor(private val orderRepository: OrderRepository) {

    suspend operator fun invoke(id: Int, menuItem: MenuItem) {
        val dataResource = orderRepository.getOrder(id).first()

        val currentOrder = when (dataResource) {
            is DataResource.Success -> dataResource.data
            else -> throw Exception("Failed to get order: $dataResource")
        }

        val existingItemIndex = currentOrder.items.indexOfFirst { it.id == menuItem.id }

        val updatedItems = if (existingItemIndex >= 0) {
            currentOrder.items.mapIndexed { index, item ->
                if (index == existingItemIndex) {
                    item.copy(quantity = item.quantity + menuItem.quantity)
                } else {
                    item
                }
            }
        } else {
            currentOrder.items + menuItem
        }

        val updatedPrice = currentOrder.price + (menuItem.price * menuItem.quantity)

        val updatedOrder = currentOrder.copy(
            items = updatedItems,
            price = updatedPrice
        )

        orderRepository.add(updatedOrder)
    }
}