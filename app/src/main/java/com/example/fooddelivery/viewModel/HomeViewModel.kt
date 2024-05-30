package com.example.fooddelivery.viewModel

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.fooddelivery.data.Address
import com.example.fooddelivery.data.Delivery
import com.example.fooddelivery.data.Food
import com.example.fooddelivery.data.FoodFavorite
import com.example.fooddelivery.data.Order
import com.example.fooddelivery.data.OrderItem
import com.example.fooddelivery.data.PaymentMethod
import com.example.fooddelivery.data.orderStatus
import com.example.fooddelivery.repository.AddressRepository
import com.example.fooddelivery.repository.FoodRepository
import com.example.fooddelivery.repository.OrderItemRepository
import com.example.fooddelivery.repository.OrderRepository
import com.example.fooddelivery.repository.foodFavRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch


class HomeViewModel(
    private val foodRepository: FoodRepository,
    private val foodFavRepository: foodFavRepository,
    private val orderRepository: OrderRepository,
    private val email: String,
    private val orderItemRepository: OrderItemRepository,
    private val addressRepository: AddressRepository
) : ViewModel() {

    private val _foods = MutableStateFlow<List<Food>>(emptyList())
    val foods get() = _foods

    init {
        viewModelScope.launch {
            foodRepository.getAllFoods().collect { foods ->
                _foods.value = foods
            }
        }
    }

    fun getEmail(): String {
        return email
    }

    fun getFoodInfo(name: String): Food? {
        val food = mutableStateOf<Food?>(null)

        viewModelScope.launch {
            food.value = foodRepository.getFoodInfo(name)
        }
        return food.value
    }

    fun getAllUserFavoriteFood(email: String): MutableStateFlow<List<Food>> {
        val favoriteFoods = MutableStateFlow<List<Food>>(emptyList())

        viewModelScope.launch {
            foodFavRepository.getAllUserFavoriteFood(email).collect { fetchedFoods ->
                favoriteFoods.value = fetchedFoods
            }
        }

        return favoriteFoods
    }

    fun likeFood(name: String) {
        var food: FoodFavorite? = null
        viewModelScope.launch {
            food = foodFavRepository.userLikeFood(email, name)
        }

        if (food == null) {
            val FoodFavorite = FoodFavorite(name, email)
            viewModelScope.launch {

                foodFavRepository.insert(FoodFavorite)
            }
        } else {
            Log.i("like_food", "food has been liked already")
        }
    }


    fun dislikeFood(name: String) {
        var food: FoodFavorite? = null
        viewModelScope.launch {
            food = foodFavRepository.userLikeFood(email, name)
        }

        if (food != null) {
            viewModelScope.launch {

                foodFavRepository.delete(food!!)
            }
        } else {
            Log.i("dislike_food", "food hasn't been liked")
        }
    }

    fun addToCart(name: String, number: Int = 1) {
        var orderList: List<Order>? = listOf()
        var food: Food? = null
        var address: Address? = null
        viewModelScope.launch {
            orderList = orderRepository.getTODOOrders(email)
            food = foodRepository.getFoodInfo(name)
            address = addressRepository.getUserAddress(name)
        }


        if (orderList?.count() == 1) {
            var orderItem: OrderItem? = null
            viewModelScope.launch {
                orderItem = orderItemRepository.getOrderItem(orderList!![0].id, name)
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

            var orderTODO: Order? = null
            viewModelScope.launch {
                orderRepository.getOrderById(orderList!![0].id)
            }



            orderTODO!!.totalPrice = orderTODO.totalPrice + number * food!!.price
            viewModelScope.launch {
                orderRepository.upsert(orderTODO)

            }

        }
        if (orderList!!.isEmpty()) {
            var allOrders: List<Order>? = null
            viewModelScope.launch {
                allOrders = orderRepository.getAllOrders()
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

    class HomeViewModelFactory(
        private val foodRepository: FoodRepository,
        private val foodFavRepository: foodFavRepository,
        private val orderRepository: OrderRepository,
        private val email: String,
        private val orderItemRepository: OrderItemRepository,
        private val addressRepository: AddressRepository
    ) : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(HomeViewModel::class.java)) {
                @Suppress("UNCHECKED_CAST")
                return HomeViewModel(
                    foodRepository,
                    foodFavRepository,
                    orderRepository,
                    email,
                    orderItemRepository,
                    addressRepository
                ) as T
            }
            throw IllegalArgumentException("Unknown ViewModel class")
        }


    }
}