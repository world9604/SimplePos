package com.example.local.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.data.model.OrderEntity
import com.example.local.LocalMapper
import com.example.local.room.RoomConstant
import com.example.local.toData

@Entity(tableName = RoomConstant.Table.ORDER)
data class OrderLocal(
    @PrimaryKey
    val id: Int,
    val price: Long,
    val items: List<MenuItemLocal>
) : LocalMapper<OrderEntity> {
    override fun toData(): OrderEntity =
        OrderEntity(
            id,
            price,
            items.toData()
        )
}

fun OrderEntity.toLocal(): OrderLocal =
    OrderLocal(
        id,
        price,
        items.map { it.toLocal() }
    )
