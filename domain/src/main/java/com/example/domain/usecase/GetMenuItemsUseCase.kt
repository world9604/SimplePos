package com.example.domain.usecase

import com.example.domain.repository.MenuRepository
import javax.inject.Inject

class GetMenuItemsUseCase @Inject constructor(private val menuRepository: MenuRepository) {

    operator fun invoke() =
        menuRepository.getMenuItems()
}