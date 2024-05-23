package com.example.fooddelivery

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.room.Room
import com.example.fooddelivery.data.AppDatabase
import com.example.fooddelivery.data.DataBase
import com.example.fooddelivery.repository.AddressRepository
import com.example.fooddelivery.repository.FoodRepository
import com.example.fooddelivery.repository.OrderItemRepository
import com.example.fooddelivery.repository.OrderRepository
import com.example.fooddelivery.repository.PersonRepository
import com.example.fooddelivery.repository.foodFavRepository
import com.example.fooddelivery.theme.FoodDeliveryTheme
import com.example.fooddelivery.viewModel.AuthViewModel
import com.example.fooddelivery.viewModel.HomeViewModel
import com.example.fooddelivery.viewModel.PaymentViewModel
import com.example.fooddelivery.viewModel.ProfileViewModel

class MainActivity : ComponentActivity() {
    private  val db by lazy{
        Room.databaseBuilder(
            applicationContext,
            DataBase ::class.java,
            "DataBase"

        ).build()
    }
    private val personViewModel: AuthViewModel by viewModels {
        AuthViewModel.AuthViewModelFactory(PersonRepository(AppDatabase.getDatabase(this).personDao()))
    }
    private val homeViewModel: HomeViewModel by viewModels {
        HomeViewModel.HomeViewModelFactory(
            FoodRepository(AppDatabase.getDatabase(this).foodDao()),
            foodFavRepository(AppDatabase.getDatabase(this).foodFavDao()),
            OrderRepository(AppDatabase.getDatabase(this).orderDao()),
            OrderItemRepository(AppDatabase.getDatabase(this).orderItemDao()),
            AddressRepository(AppDatabase.getDatabase(this).addressDao()),
        "matinmotmaen@gmail.com"
        )
    }
    private val paymentViewModel: PaymentViewModel by viewModels {
        PaymentViewModel.PaymentViewModelFactory(
            OrderRepository(AppDatabase.getDatabase(this).orderDao()),
            OrderItemRepository(AppDatabase.getDatabase(this).orderItemDao()),
            FoodRepository(AppDatabase.getDatabase(this).foodDao()),
            AddressRepository(AppDatabase.getDatabase(this).addressDao()),
            "matinmotmaen@gmail.com"
        )
    }
    private val profileViewModel: ProfileViewModel by viewModels {
        ProfileViewModel.ProfileViewModelFactory(
            PersonRepository(AppDatabase.getDatabase(this).personDao()),
            AddressRepository(AppDatabase.getDatabase(this).addressDao()),
            "matinmotmaen@gmail.com"
        )
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        personViewModel.signUp("matinmotmaen@gmail.com", "zxcvbnm0", {
            // Navigate to home screen or show success message
        }, { errorMessage ->
            // Show error message
            Toast.makeText(this, errorMessage, Toast.LENGTH_SHORT).show()
        })

        personViewModel.login("matinmotmaen@gmail.com", "zxcvbnm0")

        Log.i("tmpppppppp", db.isOpen.toString())
        setContent {
            FoodDeliveryTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MainScreen()
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    FoodDeliveryTheme {
        Greeting("Android")
    }
}