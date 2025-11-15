package com.example.local.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.data.model.MenuItemEntity
import com.example.local.LocalMapper
import com.example.local.room.RoomConstant

@Entity(tableName = RoomConstant.Table.MENU_ITEM)
data class MenuItemLocal(
    @PrimaryKey
    val id: Int,
    val name: String,
    val quantity: Int,
    val price: Int,
    val category: CategoryLocal,
    val imageUrl: String? = null
) : LocalMapper<MenuItemEntity> {
    override fun toData(): MenuItemEntity =
        MenuItemEntity(
            id,
            name,
            quantity,
            price,
            category.toData(),
            imageUrl
        )
}


fun MenuItemEntity.toLocal(): MenuItemLocal =
    MenuItemLocal(
        id,
        name,
        quantity,
        price,
        category.toLocal(),
        imageUrl
    )
