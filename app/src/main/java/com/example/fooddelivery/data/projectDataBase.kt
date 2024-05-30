package com.example.fooddelivery.data

import android.app.Application
import android.content.Context
import androidx.room.CoroutinesRoom
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.fooddelivery.R
import com.example.fooddelivery.data.dao.AddressDao
import com.example.fooddelivery.data.dao.FoodDao
import com.example.fooddelivery.data.dao.OrderDao
import com.example.fooddelivery.data.dao.OrderItemDao
import com.example.fooddelivery.data.dao.PersonDao
import com.example.fooddelivery.data.dao.foodFavDao
import com.example.fooddelivery.repository.AddressRepository
import com.example.fooddelivery.repository.FoodRepository
import com.example.fooddelivery.repository.OrderItemRepository
import com.example.fooddelivery.repository.OrderRepository
import com.example.fooddelivery.repository.PersonRepository
import com.example.fooddelivery.repository.foodFavRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch

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

    private class WordDatabaseCallback(
        private val scope: CoroutineScope
    ) : RoomDatabase.Callback() {

        override fun onCreate(db: SupportSQLiteDatabase) {
            super.onCreate(db)
            INSTANCE?.let { database ->
                scope.launch {
                    populateDatabase(database.foodDao())
                }
            }
        }

        suspend fun populateDatabase(foodDao:FoodDao) {
            // Delete all content here.
            foodDao.deleteAll()

            var food1=Food("Veggie tomato mix", "N1,900", 100, R.drawable.food_1)
            var food2= Food("Egg and cucumber", "N1,900", 200, R.drawable.food_2)
            var food3=Food("Pizza", "N1,900", 250, R.drawable.food_3)
            var food4=Food("Kabab ", "N1,900", 480, R.drawable.food_4)
            var food5=Food("Chicken", "N1,900", 100, R.drawable.food_1)
            foodDao.upsertFood(food1)
            foodDao.upsertFood(food2)
            foodDao.upsertFood(food3)
            foodDao.upsertFood(food4)
            foodDao.upsertFood(food5)
        }
    }



    companion object {
        // Singleton prevents multiple instances of database opening at the
        // same time.
        @Volatile
        private var INSTANCE:DataBase? = null

        fun getDatabase(
            context: Context,
            scope: CoroutineScope
        ): DataBase {
            // if the INSTANCE is not null, then return it,
            // if it is, then create the database
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    DataBase::class.java,
                    "project_database"
                ).addCallback(WordDatabaseCallback(scope))
                    .allowMainThreadQueries()
                    .build()
                INSTANCE = instance
                instance
            }
        }
    }

}

class ProjectDataBase : Application() {
    val applicationScope = CoroutineScope(SupervisorJob())

    // Using by lazy so the database and the repository are only created when they're needed
    // rather than when the application starts
    val database by lazy { DataBase.getDatabase(this, applicationScope) }
    val addressRepository by lazy { AddressRepository(database.addressDao()) }
    val foodFavRepository by lazy { foodFavRepository(database.foodFavDao()) }
    val foodRepository by lazy { FoodRepository(database.foodDao()) }
    val orderItemRepository by lazy { OrderItemRepository(database.orderItemDao()) }
    val orderRepository by lazy { OrderRepository(database.orderDao()) }
    val personRepository by lazy { PersonRepository(database.personDao()) }


}