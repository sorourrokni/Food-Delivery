package com.example.fooddelivery.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.fooddelivery.data.dao.AddressDao
import com.example.fooddelivery.data.dao.FoodDao
import com.example.fooddelivery.data.dao.OrderDao
import com.example.fooddelivery.data.dao.OrderItemDao
import com.example.fooddelivery.data.dao.PersonDao
import com.example.fooddelivery.data.dao.foodFavDao

@Database(
    entities = [Address::class,Food::class,foodFav::class,Order::class,OrderItem::class,Person::class],
    version = 1,
)
abstract class DataBase:RoomDatabase() {
    abstract fun addressDao(): AddressDao
    abstract fun foodDao():FoodDao
    abstract fun foodFavDao():foodFavDao
    abstract fun orderDao():OrderDao
    abstract fun orderItemDao():OrderItemDao
    abstract fun personDao():PersonDao
}
