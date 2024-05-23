package com.example.fooddelivery.viewModel

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.fooddelivery.R
import com.example.fooddelivery.data.Person
import com.example.fooddelivery.repository.PersonRepository
import kotlinx.coroutines.launch
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

class AuthViewModel(private val personRepository: PersonRepository):ViewModel() {

    private var verificationCode by mutableIntStateOf(0)

    fun login(email: String, password: String): Boolean {
        var person: Person?
        var result = false
        viewModelScope.launch {
            person = personRepository.getPersonWithEmail(email)
            if (person != null) {
                result = if (person?.password == password) {
                    Log.i("login", "${person?.email} entered")
                    //navigation
                    true
                } else {
                    Log.i("login", "${person?.email} wrong password")
                    //navigation
                    false
                }
            }
            else{
                result = false
                Log.i("login", "$email does not exist")
            }
        }
        return result
    }


    fun signUp(email: String, password: String,  onSuccess: () -> Unit, onError: (String) -> Unit) {
        viewModelScope.launch {
            val person = personRepository.getPersonWithEmail(email)
            if (person == null) {
                Log.i("singUp", "$email signed up correctly")
                val newPerson = Person(email, "", "", password, R.drawable.person1)
                personRepository.upsert(newPerson)
                onSuccess()
            } else {
                Log.i("singUp", "$email has registered already")
                onError("$email has registered already")
            }
        }
    }
    fun sendEmail(email: String) {
        verificationCode = ThreadLocalRandom.current().nextInt(1000, 9999)
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
            mimeMessage.setText(
                "Hi $email" +
                        "\t here is your verification code : $verificationCode"
            )
            val t = Thread {
                try {
                    Transport.send(mimeMessage)
                } catch (e: MessagingException) {
                    // Handling messaging exception
                    Log.e("email_result", e.toString())
                    e.printStackTrace()
                }
            }
            t.start()
        } catch (e: AddressException) {
            Log.e("email_result", e.toString())
        } catch (e: MessagingException) {
            Log.e("email_result", e.toString())
        }
        Log.e("email_result", "Sent Successfully")
    }

    fun verification(input: Int): Boolean {
        return input == verificationCode
    }

    fun createListOfUser(persons: List<Person>) {
        viewModelScope.launch {
            for (p in persons.iterator()) {
                personRepository.upsert(p)
            }
        }
    }

    fun getAllPersons(): List<Person>{
        var persons: MutableList<Person> = mutableListOf()
        viewModelScope.launch {
            persons = (personRepository.getAllPerson() as MutableList<Person>?)!!
        }
        return persons
    }


    class AuthViewModelFactory(private val repository: PersonRepository) :
        ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(AuthViewModel::class.java)) {
                @Suppress("UNCHECKED_CAST")
                return AuthViewModel(repository) as T
            }
            throw IllegalArgumentException("Unknown ViewModel class")
        }

    }

}