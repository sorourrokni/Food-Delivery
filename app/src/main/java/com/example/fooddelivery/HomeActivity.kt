package com.example.fooddelivery

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModelProvider
import androidx.room.Room
import com.example.fooddelivery.data.DataBase
import com.example.fooddelivery.data.dao.PersonDao
import com.example.fooddelivery.theme.FoodDeliveryTheme
import com.example.fooddelivery.ui.auth.AuthLayout
import com.example.fooddelivery.viewModel.AuthViewModel
import com.example.fooddelivery.ui.auth.login.LoginScreen
import com.example.fooddelivery.ui.home.HomeScreen
import com.example.fooddelivery.viewModel.AuthViewModelFactory
import com.example.fooddelivery.viewModel.PersonRepository
import com.example.fooddelivery.navigation.NavControllerWithHistory

class HomeActivity : AppCompatActivity() {

    private lateinit var personDao: PersonDao
    private lateinit var viewModel: AuthViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.circle_1)


//        viewModel = ViewModelProvider(this)[AuthViewModel::class.java]


        // Initialize the database and PersonDao
        val db = Room.databaseBuilder(
            applicationContext,
            DataBase::class.java,
            "DataBase"
        ).build()
        personDao = db.personDao()

        val personRepo = PersonRepository(personDao)
        // Create the ViewModel using the factory
        val factory = AuthViewModelFactory(personRepo)
        viewModel = ViewModelProvider(this, factory)[AuthViewModel::class.java]


        setContent {
            FoodDeliveryTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ){
//                    HomeScreen()
                    MainScreen()
                }
            }
        }

    }
}