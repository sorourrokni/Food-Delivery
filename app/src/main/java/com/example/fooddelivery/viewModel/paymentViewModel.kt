package com.example.fooddelivery.viewModel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.fooddelivery.data.Address
import com.example.fooddelivery.data.Delivery
import com.example.fooddelivery.data.Food
import com.example.fooddelivery.data.Order
import com.example.fooddelivery.data.OrderItem
import com.example.fooddelivery.data.PaymentMethod
import com.example.fooddelivery.data.dao.AddressDao
import com.example.fooddelivery.data.dao.FoodDao
import com.example.fooddelivery.data.dao.OrderDao
import com.example.fooddelivery.data.dao.OrderItemDao
import com.example.fooddelivery.data.orderStatus
import com.example.fooddelivery.repository.AddressRepository
import com.example.fooddelivery.repository.FoodRepository
import com.example.fooddelivery.repository.OrderItemRepository
import com.example.fooddelivery.repository.OrderRepository
import kotlinx.coroutines.launch

class PaymentViewModel(
    private val orderRepository: OrderRepository,
    private val orderItemRepository: OrderItemRepository,
    private val foodRepository: FoodRepository,
    private val addressRepository: AddressRepository,
    private val email:String
): ViewModel() {
    fun addToCart(name: String, number: Int) {
        var orderList:List<Order>?= listOf()
        var food: Food?=null
        var address: Address?=null
        viewModelScope.launch {
            orderList = orderRepository.getTODOOrders(email)
            food = foodRepository.getFoodInfo(name)
            address = addressRepository.getUserAddress(name)
        }
        if (orderList?.count() == 1) {
            var orderItem :OrderItem?=null
            viewModelScope.launch {
                orderItem=orderItemRepository.getOrderItem(orderList!![0].id, name)
            }
            if (orderItem == null) {
                var newOrderItem = OrderItem(number, orderList!![0].id, name)
                viewModelScope.launch {
                    orderItemRepository.upsert(newOrderItem)
                }
            } else {
                orderItem!!.quantity = orderItem!!.quantity + number
                viewModelScope.launch {
                    orderItemRepository.upsert(orderItem!!)
                }
            }
            var orderTODO:Order?=null
            viewModelScope.launch {
                orderRepository.getOrderById(orderList!![0].id)
            }
            orderTODO!!.totalPrice = orderTODO.totalPrice + number * food!!.price
            viewModelScope.launch {
                orderRepository.upsert(orderTODO)
            }


        }
        if (orderList!!.isEmpty()) {
            var allOrders :List<Order>?=null
            viewModelScope.launch {
                allOrders= orderRepository.getAllOrders()
            }

            if (allOrders!!.isEmpty()) {
                val order = Order(
                    1, food!!.price, PaymentMethod.DirectPay, Delivery.PickUp, address!!.id, email,
                    orderStatus.TODO
                )
                viewModelScope.launch {
                    orderRepository.upsert(order)
                }

            } else {
                val order = Order(
                    allOrders!!.last().id + 1,
                    food!!.price,
                    PaymentMethod.DirectPay,
                    Delivery.PickUp,
                    address!!.id,
                    email,
                    orderStatus.TODO
                )
                viewModelScope.launch {
                    orderRepository.upsert(order)
                }
            }

        } else {
            Log.e("custom_error", "error in orders: there is two TODO Cart")
        }
    }

    fun removeFromCart(name: String, number: Int) {
        var orderList :List<Order>?=null
        var food :Food?=null
        viewModelScope.launch {
            orderList=orderRepository.getTODOOrders(email)
            food=foodRepository.getFoodInfo(name)
        }

        if (orderList==null) {
            Log.e("custom_error", "error in orders: there no TODO Cart")
        } else {
            if (orderList?.count() == 1) {
                var orderItem :OrderItem?=null
                viewModelScope.launch {
                    orderItem=orderItemRepository.getOrderItem(orderList!![0].id, name)
                }
                if (orderItem != null) {
                    if (number >= orderItem!!.quantity) {
                        orderList!![0].totalPrice -= food!!.price * orderItem!!.quantity
                        viewModelScope.launch{
                            orderItemRepository.delete(orderItem!!)
                            orderRepository.upsert(orderList!![0])
                        }
                    } else {
                        orderItem!!.quantity -= number
                        orderList!![0].totalPrice -= food!!.price * number
                        viewModelScope.launch{
                            orderItemRepository.upsert(orderItem!!)
                            orderRepository.upsert(orderList!![0])
                        }
                    }
                } else {
                    Log.e(
                        "custom_error",
                        "error in orderItems: there is orderItems to change the quantity"
                    )
                }

            } else {
                Log.e("custom_error", "error in orders: there is two TODO Cart")
            }
        }
    }

    fun deliveryChange(address: Address, deliverMethode: Delivery) {
        var orderList:List<Order>? =null
        viewModelScope.launch {

            orderList=orderRepository.getTODOOrders(email)
        }

        if (orderList?.count() == 1) {
            orderList!![0].deliveryMethod = deliverMethode
            orderList!![0].addressID = address.id

            viewModelScope.launch {
                orderRepository.upsert(orderList!![0])
            }
        }
        if (orderList==null) {
            Log.e("custom_error", "error in orders: there is TODO Cart")
        } else {
            Log.e("custom_error", "error in orders: there is two TODO Cart")
        }
    }

    fun paymentChange(paymentMethod: PaymentMethod, deliverMethode: Delivery) {
        var orderList:List<Order>? =null
        viewModelScope.launch {

            orderList=orderRepository.getTODOOrders(email)
        }
        if (orderList?.count() == 1) {
            orderList!![0].deliveryMethod = deliverMethode
            orderList!![0].paymentMethod = paymentMethod
            viewModelScope.launch {
                orderRepository.upsert(orderList!![0])
            }
        }
        if (orderList==null) {
            Log.e("custom_error", "error in orders: there is TODO Cart")
        } else {
            Log.e("custom_error", "error in orders: there is two TODO Cart")
        }
    }

    class PaymentViewModelFactory(
        private val orderRepository: OrderRepository,
        private val orderItemRepository: OrderItemRepository,
        private val foodRepository: FoodRepository,
        private val addressRepository: AddressRepository,
        private val email: String
    ) : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(PaymentViewModel::class.java)) {
                @Suppress("UNCHECKED_CAST")
                return PaymentViewModel(
                    orderRepository,
                    orderItemRepository,
                    foodRepository,
                    addressRepository,
                    email
                ) as T
            }
            throw IllegalArgumentException("Unknown ViewModel class")
        }

    }
}