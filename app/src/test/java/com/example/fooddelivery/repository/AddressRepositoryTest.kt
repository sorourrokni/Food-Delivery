package com.example.fooddelivery.repository

import com.example.fooddelivery.data.Address
import com.example.fooddelivery.data.dao.AddressDao
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.`when`
import org.mockito.Mockito.mock
import org.mockito.Mockito.verify

class AddressRepositoryTest {

    private lateinit var addressRepository: AddressRepository
    private lateinit var addressDao: AddressDao

    @Before
    fun setup() {
        addressDao = mock(AddressDao::class.java)
        addressRepository = AddressRepository(addressDao)
    }

    @Test
    fun testUpsertAddress() = runBlocking {
        val address = Address(
            id = 1,
            address = "123 Main St",
            description = "Home address",
            user = "user1@example.com"
        )

        addressRepository.upsert(address)

        // Verify that the upsertAddress method is called with the correct address
        verify(addressDao).upsertAddress(address)
    }

    @Test
    fun testGetUserAddress() = runBlocking {
        val email = "user1@example.com"
        val expectedAddress = Address(
            id = 1,
            address = "123 Main St",
            description = "Home address",
            user = email
        )

        // Mock the behavior of getUserAddress method in the DAO
        `when`(addressDao.getUserAddress(email)).thenReturn(expectedAddress)

        // Call the repository method
        val result = addressRepository.getUserAddress(email)

        // Verify that the result matches the expected address
        assertEquals(expectedAddress, result)
    }
}
