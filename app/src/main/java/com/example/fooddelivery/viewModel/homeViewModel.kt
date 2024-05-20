package com.example.fooddelivery.viewModel

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.fooddelivery.data.Food
import com.example.fooddelivery.data.dao.FoodDao
import com.example.fooddelivery.data.dao.OrderDao
import com.example.fooddelivery.data.dao.foodFavDao
import com.example.fooddelivery.data.foodFav

class homeViewModel(
    private val foodDao: FoodDao
    ,private val foodFavDao: foodFavDao
    ,private val orderDao: OrderDao
    ,private val email:String): ViewModel() {
    fun getDishes():List<Food>{
        return foodDao.getAllFood()
    }
    fun getSomeDishes(number:Int):List<Food>{
        return foodDao.getSomeFood(number)
    }
    fun getFoodInfo(name:String):Food{
        return foodDao.getFoodByName(name)
    }
    fun getFavoriteFoods():List<Food>{
        return foodFavDao.getAllFoodFavByUserID(email)
    }
    fun likeFood(name: String){
        val food=foodFavDao.userLikeFood(email,name)
        if (food==null){
            val foodFav=foodFav(name,email)
            foodFavDao.insertFoodFav(foodFav)
        }
        else{
            Log.i("like_food","food has been liked already")
        }
    }
    fun disLikeFood(name:String){
        val food=foodFavDao.userLikeFood(email,name)
        if (food!=null){
            val foodFav=foodFav(name,email)
            foodFavDao.deleteFoodFav(foodFav)
        }
        else{
            Log.i("like_food","food hasn't been liked ")
        }
    }


}