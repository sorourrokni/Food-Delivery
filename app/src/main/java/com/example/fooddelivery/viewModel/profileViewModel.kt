package com.example.fooddelivery.viewModel;

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.fooddelivery.data.Person
import com.example.fooddelivery.data.dao.AddressDao
import com.example.fooddelivery.data.dao.PersonDao
import com.example.fooddelivery.repository.AddressRepository
import com.example.fooddelivery.repository.PersonRepository

class profileViewModel(
    private val personRepository: PersonRepository,
    private val addressRepository: AddressRepository,
    private val email:String)
    : ViewModel() {
    fun getProfileInfo(email: String): Person? {
        try {
            return personDao.getPersonWithEmail(email)
        } catch (e: Exception) {
            Log.i("getProfileError", e.toString())
            return null
        }
    }

    fun updateProfileInfo(name: String, newEmail: String, phone: String, address: String): Boolean {
        val person = personDao.getPersonWithEmail(newEmail)
        if (person == null) {
            val oldPerson = personDao.getPersonWithEmail(email)
            if (oldPerson != null) {
                oldPerson.email = newEmail
                oldPerson.fullName = name
                oldPerson.phoneNumber = phone
                val addressObject = addressDao.getUserAddress(email)
                if (addressObject != null) {
                    addressObject.description = address
                    addressObject.user = newEmail
                    addressDao.upsertAddress(addressObject)
                }
                personDao.upsertPerson(oldPerson)
                return true

            } else {
                Log.e("custom_error", "person with this email couldn't be founded")
                return false
            }

        } else {
            return false
        }
    }

    class profileViewModelFactory(
        private val personRepository: PersonRepository,
        private val addressRepository: AddressRepository,
        private val email: String
    ) : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(profileViewModel::class.java)) {
                @Suppress("UNCHECKED_CAST")
                return profileViewModel(
                    personRepository, addressRepository, email
                ) as T
            }
            throw IllegalArgumentException("Unknown ViewModel class")
        }


    }
}
