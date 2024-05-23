package com.example.fooddelivery.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import com.example.fooddelivery.data.Order
import com.example.fooddelivery.data.OrderItem
import kotlinx.coroutines.flow.Flow

@Dao
interface OrderDao {
    @Upsert
     fun upsertOrder(order: Order)
    @Delete
    suspend fun deleteOrder(order: Order)

    @Query("select * from `order` inner join Person on(userID==email) where Person.email==:inputEmail")
    fun getAllOrdersByUser(inputEmail:String): Flow<List<Order>>
    @Query("select * from orderitem inner join `order` on (orderID==id)where orderID==:inputID")
    fun getOrderItemsByID(inputID:Int):Flow<List<OrderItem>>
    @Query("select * from address inner join `order`  on (`order`.id==addressID)where address.id==:inputID")
    fun getOrderAddressByID(inputID:Int):Flow<List<Order>>
    @Query("select * from `order` natural join person where person.email==:email and `order`.status=='DONE'")
    fun getUserHistory(email:String):Flow<List<Order>>
    @Query("select * from `order` natural join person where person.email==:email and `order`.status=='TODO'")
    fun getUserTODOCart(email:String):Flow<List<Order>>
    @Query("select * from `order`")
    fun getAllOrders():Flow<List<Order>>
    @Query("select * from `order` where id==:inputID")
    fun getOrderById(inputID: Int):Flow<Order>
}