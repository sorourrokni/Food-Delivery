package com.example.fooddelivery.viewModel

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fooddelivery.R
import com.example.fooddelivery.data.Person
import com.example.fooddelivery.data.dao.PersonDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.util.concurrent.ThreadLocalRandom
import javax.mail.Authenticator
import javax.mail.Message
import javax.mail.MessagingException
import javax.mail.PasswordAuthentication
import javax.mail.Session
import javax.mail.Transport
import javax.mail.internet.AddressException
import javax.mail.internet.InternetAddress
import javax.mail.internet.MimeMessage


class PersonRepository(private val personDao: PersonDao) {

    suspend fun userExist(email: String): Person? {
        // Perform the database operation to check if the user exists
        return personDao.getPersonWithEmail(email)
    }
    suspend fun signup(person : Person) {
        // Perform the database operation to check if the user exists
        return personDao.upsertPerson(person)
    }
}

class AuthViewModel(private val personRepository: PersonRepository):ViewModel() {

    var verificationCode by mutableIntStateOf(0)
    suspend fun login(email: String, password: String, param: (Person) -> Unit) {
        viewModelScope.launch {
            val isSuccess = withContext(Dispatchers.IO) {
                personRepository.userExist(email)
            }
            if (isSuccess != null) {
                onResult(isSuccess, password)
            }
        }

    }

    private fun onResult(person: Person, password: String): Boolean {
        return if (person.password ==password){
            Log.i("login","${person.email} entered")
            //navigation
            true
        } else{
            Log.i("login","${person.email} wrong password")
            //navigation
            false
        }
    }


    suspend fun signUp(email: String, password: String, param: (Any) -> Unit) {
        viewModelScope.launch {
            val isSuccess = withContext(Dispatchers.IO) {
                personRepository.userExist(email)
            }
            if (isSuccess != null) {
                onResult(isSuccess, password)
            }
        }
//        val person: Person? = personRepository.userExist(email)
//        return if (person == null) {
//            Log.i("singUp", "$email signed up correctly")
//            val newPerson = Person(email, "", "", password, R.drawable.person1)
//            personRepository.signup(newPerson)
//            true
//        } else {
//            Log.i("singUp", "$email has registered already")
//            false
//        }

    }

    fun sendEmail(email:String) {
        verificationCode= ThreadLocalRandom.current().nextInt(1000,9999)
        try {
            // Defining sender's email and password
            val senderEmail = "fooddelivery.emailsender@gmail.com"
            val password = "lvpz wogq avwb yrxj"
            val receiverEmail = email
            val stringHost = "smtp.gmail.com"
            val properties = System.getProperties()
            properties["mail.smtp.host"] = stringHost
            properties["mail.smtp.port"] = "465"
            properties["mail.smtp.ssl.enable"] = "true"
            properties["mail.smtp.auth"] = "true"
            val session = Session.getInstance(properties, object : Authenticator() {
                override fun getPasswordAuthentication(): PasswordAuthentication {
                    return PasswordAuthentication(senderEmail, password)
                }
            })
            val mimeMessage = MimeMessage(session)
            mimeMessage.addRecipient(Message.RecipientType.TO, InternetAddress(receiverEmail))
            mimeMessage.subject = "Verification Code"
            mimeMessage.setText("Hi $email" +
                    "\t here is your verification code : $verificationCode")
            val t = Thread {
                try {
                    Transport.send(mimeMessage)
                } catch (e: MessagingException) {
                    // Handling messaging exception
                    Log.e("email_result",e.toString())
                    e.printStackTrace()
                }
            }
            t.start()
        } catch (e: AddressException) {
            Log.e("email_result",e.toString())
        } catch (e: MessagingException) {
            Log.e("email_result",e.toString())
        }
        Log.e("email_result","Sent Successfully")
    }
    fun verification(input:Int):Boolean{
        return input==verificationCode
    }

    suspend fun createNewUser(email: String, password: String){
        val person=Person(email,"","", password,R.drawable.person1)
        try {
            personRepository.signup(person)
        }
        catch (e :Exception){
            Log.e("custom_error",e.toString())
        }

    }
}