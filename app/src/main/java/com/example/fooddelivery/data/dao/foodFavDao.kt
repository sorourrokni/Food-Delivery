package com.example.fooddelivery.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.fooddelivery.data.Food
import com.example.fooddelivery.data.FoodFavorite

@Dao
interface foodFavDao {
    @Insert
     fun insertFoodFav(FoodFavorite: FoodFavorite)
    @Delete
     fun deleteFoodFav(FoodFavorite: FoodFavorite)
    @Query("select name,description,price,imageResId from FoodFavorite natural join food where FoodFavorite.userID==:email")
    fun getAllFoodFavByUserID(email:String):List<Food>
    @Query("select FoodFavorite.foodID,FoodFavorite.userID from FoodFavorite , person , food where FoodFavorite.userID==:email and FoodFavorite.foodID==:name")
    fun userLikeFood(email:String,name:String):FoodFavorite


}