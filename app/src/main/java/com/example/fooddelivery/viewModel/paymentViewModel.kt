package com.example.fooddelivery.viewModel

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.fooddelivery.data.Address
import com.example.fooddelivery.data.Delivery
import com.example.fooddelivery.data.Order
import com.example.fooddelivery.data.OrderItem
import com.example.fooddelivery.data.dao.AddressDao
import com.example.fooddelivery.data.dao.FoodDao
import com.example.fooddelivery.data.dao.OrderDao
import com.example.fooddelivery.data.dao.OrderItemDao
import com.example.fooddelivery.data.orderStatus
import com.example.fooddelivery.data.payment_method

class paymentViewModel(
    private val orderDao: OrderDao,
    private val orderItemDao: OrderItemDao,
    private val foodDao: FoodDao,
    private val addressDao: AddressDao,
    private val email:String
): ViewModel() {
    fun addToCart(name:String,number:Int){
        val orderList=orderDao.getUserTODOCart(email)
        val food=foodDao.getFoodByName(name)
        val address=addressDao.getUserAddress(name)
        if (orderList?.count()==1){
            val orderItem=orderItemDao.getOrderItemWithFoodIDAndOrderID(orderList[0].id,name)
            if(orderItem==null){
                val newOrderItem= OrderItem(number,orderList[0].id,name)
                orderItemDao.upsertOrderItem(newOrderItem)
            }
            else{
                orderItem.quantity=orderItem.quantity+number
                orderItemDao.upsertOrderItem(orderItem)
            }

            val orderTODO=orderDao.getOrderById(orderList[0].id)
            orderTODO.totalPrice=orderTODO.totalPrice+number*food.price
            orderDao.upsertOrder(orderTODO)

        }
        if (orderList.isEmpty()){
            val allOrders=orderDao.getAllOrders()
            if (allOrders.isEmpty()){
                val order= Order(1,food.price,
                    payment_method.Direct_pay,
                    Delivery.PickUp,address.id,email,
                    orderStatus.TODO)
                orderDao.upsertOrder(order)
            }
            else{
                val order= Order(allOrders.last().id+1,food.price,
                    payment_method.Direct_pay,
                    Delivery.PickUp,address.id,email,
                    orderStatus.TODO)
                orderDao.upsertOrder(order)
            }

        }
        else{
            Log.e("custom_error","error in orders: there is two TODO Cart")
        }
    }
    fun removeFromCart(name:String,number: Int){
        val orderList=orderDao.getUserTODOCart(email)
        val food=foodDao.getFoodByName(name)
        if(orderList.isEmpty()){
            Log.e("custom_error","error in orders: there no TODO Cart")
        }
        else{
            if(orderList.count()==1){
                val orderItem=orderItemDao.getOrderItemWithFoodIDAndOrderID(orderList[0].id,name)
                if(orderItem!=null){
                    if (number>=orderItem.quantity){
                        orderList[0].totalPrice-=food.price*orderItem.quantity
                        orderItemDao.deleteOrderItem(orderItem)
                        orderDao.upsertOrder(orderList[0])
                    }
                    else{
                        orderItem.quantity-=number
                        orderItemDao.upsertOrderItem(orderItem)
                        orderList[0].totalPrice-=food.price*number
                        orderDao.upsertOrder(orderList[0])
                    }
                }
                else{
                    Log.e("custom_error","error in orderItems: there is orderItems to change the quantity")
                }

            }
            else{
                Log.e("custom_error","error in orders: there is two TODO Cart")
            }
        }
    }
    fun deliveryChange(address: Address,deliverMethode:Delivery){
        val orderList=orderDao.getUserTODOCart(email)
        if (orderList?.count()==1){
           orderList[0].deliveryMethod=deliverMethode
            orderList[0].addressID=address.id
            orderDao.upsertOrder(orderList[0])
        }
        if (orderList.isEmpty()){
            Log.e("custom_error","error in orders: there is TODO Cart")
        }
        else{
            Log.e("custom_error","error in orders: there is two TODO Cart")
        }
    }
    fun paymentChange(paymentMethod: payment_method,deliverMethode: Delivery){
        val orderList=orderDao.getUserTODOCart(email)
        if (orderList?.count()==1){
            orderList[0].deliveryMethod=deliverMethode
            orderList[0].paymentMethod=paymentMethod
            orderDao.upsertOrder(orderList[0])
        }
        if (orderList.isEmpty()){
            Log.e("custom_error","error in orders: there is TODO Cart")
        }
        else{
            Log.e("custom_error","error in orders: there is two TODO Cart")
        }
    }

}