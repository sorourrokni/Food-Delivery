package com.example.fooddelivery

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.fooddelivery.component.NavigationItem
import com.example.fooddelivery.data.Person
import com.example.fooddelivery.theme.FoodDeliveryTheme
import com.example.fooddelivery.ui.auth.forgotpassword.ForgotPasswordScreen
import com.example.fooddelivery.ui.auth.lostconnection.LostConnectionScreen
import com.example.fooddelivery.ui.auth.verification.VerificationScreen
import com.example.fooddelivery.ui.home.HomeScreen
import com.example.fooddelivery.ui.profile.ProfileScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FoodDeliveryTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
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