package com.example.fooddelivery

import android.app.Application
import com.example.fooddelivery.data.DataBase
import com.example.fooddelivery.repository.AddressRepository
import com.example.fooddelivery.repository.FoodRepository
import com.example.fooddelivery.repository.OrderItemRepository
import com.example.fooddelivery.repository.OrderRepository
import com.example.fooddelivery.repository.PersonRepository
import com.example.fooddelivery.repository.foodFavRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob

class ProjectDataBase : Application() {
    val applicationScope = CoroutineScope(SupervisorJob())

    // Using by lazy so the database and the repository are only created when they're needed
    // rather than when the application starts
    val database by lazy { DataBase.getDatabase(this,applicationScope) }
    val addressRepository by lazy { AddressRepository(database.addressDao()) }
    val foodFavRepository by lazy { foodFavRepository(database.foodFavDao()) }
    val foodRepository by lazy { FoodRepository(database.foodDao()) }
    val orderItemRepository by lazy { OrderItemRepository(database.orderItemDao()) }
    val orderRepository by lazy { OrderRepository(database.orderDao()) }
    val personRepository by lazy { PersonRepository(database.personDao()) }


}
