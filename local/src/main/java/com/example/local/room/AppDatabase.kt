package com.example.local.room

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.local.model.MenuItemLocal
import com.example.local.model.OrderLocal
import com.example.local.room.dao.MenuItemDao
import com.example.local.room.dao.OrderDao

@Database(
    entities = [OrderLocal::class, MenuItemLocal::class],
    version = RoomConstant.ROOM_VERSION
)
@TypeConverters(DtoConverter::class)
abstract class AppDatabase : RoomDatabase() {

    abstract fun orderDao(): OrderDao

    abstract fun menuItemDao(): MenuItemDao

}
