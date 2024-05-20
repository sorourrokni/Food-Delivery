package com.example.fooddelivery.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import com.example.fooddelivery.data.Order
import com.example.fooddelivery.data.OrderItem
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
    fun getOrderItemsByID(inputID:Int):List<OrderItem>
    @Query("select * from address inner join `order`  on (`order`.id==addressID)where address.id==:inputID")
    fun getOrderAddressByID(inputID:Int):List<Order>
    @Query("select * from `order` natural join person where person.email==:email and `order`.status=='Done'")
    fun getUserHistory(email:String):List<Order>

}