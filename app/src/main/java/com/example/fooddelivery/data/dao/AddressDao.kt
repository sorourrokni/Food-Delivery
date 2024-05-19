package com.example.fooddelivery.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Upsert
import com.example.fooddelivery.data.Address

@Dao
interface AddressDao {
    @Upsert
    suspend fun upsertAddress(address: Address)
    @Delete
    suspend fun deleteAddress(address:Address)

}