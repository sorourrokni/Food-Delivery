package com.example.fooddelivery.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import com.example.fooddelivery.data.Order
import com.example.fooddelivery.data.foodFav

@Dao
interface OrderDao {
    @Upsert
    suspend fun upsertOrder(order: Order)
    @Delete
    suspend fun deleteOrder(order: Order)

    @Query("select * from `order` inner join Person on(userID==email) where Person.email==:inputEmail")
    fun getAllOrdersByUser(inputEmail:String):List<Order>
    @Query("select * from orderitem inner join `order` on (orderID==id)where orderID==:inputID")
    fun getOrderItemsByID(inputID:Int)
    @Query("select * from address inner join `order`  on (id==addressID)where address.id==:inputID")
    fun getOrderAddressByID(inputID:Int)

}