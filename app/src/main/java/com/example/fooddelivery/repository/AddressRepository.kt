package com.example.fooddelivery.repository

import androidx.annotation.WorkerThread
import com.example.fooddelivery.data.Address
import com.example.fooddelivery.data.FoodFavorite
import com.example.fooddelivery.data.dao.AddressDao
import kotlinx.coroutines.flow.Flow

class AddressRepository(private val addressDao: AddressDao,email:String) {



    val allUserAddress: Flow<Address> = addressDao.getUserAddress(email)
    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun upsert(address: Address) {
        addressDao.upsertAddress(address)
    }
}