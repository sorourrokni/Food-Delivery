package com.example.fooddelivery.viewModel

import android.util.Log
import android.util.MutableInt
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.fooddelivery.R
import com.example.fooddelivery.data.Person
import com.example.fooddelivery.data.dao.PersonDao
import com.example.fooddelivery.event.PersonEvent
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
import kotlin.random.Random

class authViewModel(private val personDao:PersonDao):ViewModel() {

    var verificationCode by mutableStateOf(0)
    fun login(email:String,password:String):Boolean{
        var person: Person ?=personDao.getPersonWithEmail(email)
        if (person?.password==password){
            Log.i("login","${person?.email} entered")
            //navigation
            return true
        }
        else{
            Log.i("login","${person?.email} wrong password")
            //navigation
            return false
        }
    }
    fun signUp(email: String,password: String):Boolean {
        var person: Person? = personDao.getPersonWithEmail(email)
        if (person == null) {
            Log.i("singUp", "$email signed up correctly")
            var newPerson = Person(email, "", "", password, R.drawable.person1)
            personDao.upsertPerson(newPerson)
            return true
        } else {
            Log.i("singUp", "$email has registered already")
            return false
        }

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

    fun createNewUser(email: String,password: String){
        val person=Person(email,"","", password,R.drawable.person1)
        try {
            personDao.upsertPerson(person)
        }
        catch (e :Exception){
            Log.e("custom_error",e.toString())
        }

    }
}