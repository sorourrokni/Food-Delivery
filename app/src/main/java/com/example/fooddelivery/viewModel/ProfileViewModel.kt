package com.example.fooddelivery.viewModel;

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.fooddelivery.data.Address
import com.example.fooddelivery.data.Person
import com.example.fooddelivery.data.dao.AddressDao
import com.example.fooddelivery.data.dao.PersonDao
import com.example.fooddelivery.repository.AddressRepository
import com.example.fooddelivery.repository.PersonRepository
import kotlinx.coroutines.launch

class profileViewModel(
    private val personRepository: PersonRepository,
    private val addressRepository: AddressRepository,
    private val email:String)
    : ViewModel() {
    fun getProfileInfo(email: String): Person? {
        try {
            var person:Person?=null
            viewModelScope.launch {
                person=personRepository.getPersonWithEmail(email)
            }
            return person
        } catch (e: Exception) {
            Log.i("getProfileError", e.toString())
            return null
        }
    }

    fun updateProfileInfo(name: String, newEmail: String, phone: String, address: String): Boolean {
        var person:Person?=null
        viewModelScope.launch {
            person=personRepository.getPersonWithEmail(email)
        }
        if (person != null) {
            var oldPerson:Person?=null
            viewModelScope.launch {
                oldPerson=personRepository.getPersonWithEmail(email)
            }

            if (oldPerson != null) {
                oldPerson!!.email = newEmail
                oldPerson?.fullName = name
                oldPerson?.phoneNumber = phone
                var addressObject:Address?=null
                viewModelScope.launch {
                    addressObject=addressRepository.getUserAddress(email)
                }
                if (addressObject != null) {
                    addressObject?.description = address
                    addressObject?.user = newEmail
                    viewModelScope.launch{
                        addressRepository.upsert(addressObject!!)
                    }
                }
                viewModelScope.launch { personRepository.upsert(oldPerson!!) }
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
