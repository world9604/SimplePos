package com.example.domain.usecase

import com.example.domain.repository.OrderRepository
import javax.inject.Inject

class GetOrderUseCase @Inject constructor(private val orderRepository: OrderRepository) {

    operator fun invoke(id: Int) = orderRepository.getOrder(id)
}