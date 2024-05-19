package com.example.fooddelivery.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Upsert
import com.example.fooddelivery.data.Address
import com.example.fooddelivery.data.Food
import com.example.fooddelivery.data.foodFav

@Dao
interface foodFavDao {
    @Insert
    suspend fun insertFoodFav(foodFav: foodFav)
    @Delete
    suspend fun deleteFoodFav(foodFav: foodFav)
    @Query("select name,description,price,imageResId from foodFav natural join food where foodFav.userID==:email" )
    fun getAllFoodFavByUserID(email:String):List<Food>



}