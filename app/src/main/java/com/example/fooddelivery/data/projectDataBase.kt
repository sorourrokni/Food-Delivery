package com.example.fooddelivery.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.fooddelivery.data.dao.AddressDao
import com.example.fooddelivery.data.dao.FoodDao
import com.example.fooddelivery.data.dao.OrderDao
import com.example.fooddelivery.data.dao.OrderItemDao
import com.example.fooddelivery.data.dao.PersonDao
import com.example.fooddelivery.data.dao.foodFavDao

@Database(
    entities = [Address::class,Food::class,FoodFavorite::class,Order::class,OrderItem::class,Person::class],
    version = 1,
)
abstract class DataBase:RoomDatabase() {
    abstract fun addressDao(): AddressDao
    abstract fun foodDao():FoodDao
    abstract fun foodFavDao():foodFavDao
    abstract fun orderDao():OrderDao
    abstract fun orderItemDao():OrderItemDao
    abstract fun personDao():PersonDao


    companion object {
        // Singleton prevents multiple instances of database opening at the
        // same time.
        @Volatile
        private var INSTANCE:DataBase? = null

        fun getDatabase(context: Context): DataBase {
            // if the INSTANCE is not null, then return it,
            // if it is, then create the database
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    DataBase::class.java,
                    "project_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }

}
