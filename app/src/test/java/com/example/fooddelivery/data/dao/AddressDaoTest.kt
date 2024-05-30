// File: AddressDaoTest.kt
package com.example.fooddelivery.data.dao

import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.fooddelivery.data.Address
import com.example.fooddelivery.data.DataBase
import com.example.fooddelivery.data.Person
//import junit.framework.TestCase.assertEquals
//import junit.framework.TestCase.assertNull
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
//import kotlin.test.assertEquals
//import kotlin.test.assertNull
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNull
import com.example.fooddelivery.R



@RunWith(AndroidJUnit4::class)
class AddressDaoTest {

    private lateinit var db: DataBase
    private lateinit var addressDao: AddressDao
    private lateinit var personDao: PersonDao

    @Before
    fun createDb() {
        db = Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(),
            DataBase::class.java
        ).build()
        addressDao = db.addressDao()
        personDao = db.personDao()
    }

    @After
    fun closeDb() {
        db.close()
    }

    @Test
    fun testUpsertAddress() = runBlocking {
        val person = Person(email = "user2@example.com", fullName = "John Doe", password = "password", phoneNumber = "09123456789", profileImg = R.drawable.user)
        personDao.upsertPerson(person)

        val address = Address(
            address = "123 Main St",
            description = "Home address",
            user = "user1@example.com"
        )
        addressDao.upsertAddress(address)

        val retrievedAddress = addressDao.getUserAddress("user1@example.com")
        assertEquals(address.copy(id = retrievedAddress!!.id), retrievedAddress)
    }

    @Test
    fun testDeleteAddress() = runBlocking {
        val person = Person(email = "user2@example.com", fullName = "John Doe", password = "password", phoneNumber = "09123456789", profileImg = R.drawable.user)

        personDao.upsertPerson(person)

        val address = Address(
            address = "123 Main St",
            description = "Home address",
            user = "user1@example.com"
        )
        addressDao.upsertAddress(address)

        addressDao.deleteAddress(address)
        val retrievedAddress = addressDao.getUserAddress("user1@example.com")
        assertNull(retrievedAddress)
    }

    @Test
    fun testGetUserAddress() = runBlocking {
        val person1 = Person(email = "user1@example.com", fullName = "John Doe", password = "password", phoneNumber = "09123456789", profileImg = R.drawable.user)
        val person2 = Person(email = "user2@example.com", fullName = "John Doe", password = "password", phoneNumber = "09123456789", profileImg = R.drawable.user)
        personDao.upsertPerson(person1)
        personDao.upsertPerson(person2)

        val address1 = Address(
            address = "123 Main St",
            description = "Home address",
            user = "user1@example.com"
        )
        val address2 = Address(
            address = "456 Second St",
            description = "Work address",
            user = "user2@example.com"
        )

        addressDao.upsertAddress(address1)
        addressDao.upsertAddress(address2)

        val retrievedAddress1 = addressDao.getUserAddress("user1@example.com")
        val retrievedAddress2 = addressDao.getUserAddress("user2@example.com")

        assertEquals(address1.copy(id = retrievedAddress1!!.id), retrievedAddress1)
        assertEquals(address2.copy(id = retrievedAddress2!!.id), retrievedAddress2)
    }
}

