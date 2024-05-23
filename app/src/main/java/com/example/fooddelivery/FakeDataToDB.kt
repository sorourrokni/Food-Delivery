package com.example.fooddelivery

import com.example.fooddelivery.R
import com.example.fooddelivery.data.Address
import com.example.fooddelivery.data.Category
import com.example.fooddelivery.data.Delivery
import com.example.fooddelivery.data.Food
import com.example.fooddelivery.data.Payment
import com.example.fooddelivery.data.PaymentMethod
import com.example.fooddelivery.data.Person
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



class FakeData {

//    val payment1 = Payment(
//        foodsList = linkedMapOf(
//            foods[1] to 2,
//            foods[2] to 1,
//            foods[3] to 3
//        ),
//        totalPrice = 2 * food1.price + 1 * food2.price + 3 * food3.price,
//        address = address1,
//        delivery = Delivery.PickUp,
//        paymentMethod = PaymentMethod.Card,
//        person = person1
//    )
//
//    val payments = listOf(payment1, payment1, payment1)

//    order
//    orderitem
//    foodfavorite


    val persons: MutableList<Person> = mutableListOf(
        Person(
            "john.doe@example.com",
            "555-1234",
            "John Doe",
            "password123",
            R.drawable.person1
        ),
        Person(
            "jane.smith@example.com",
            "555-5678",
            "Jane Smith",
            "password456",
            R.drawable.person1
        ),
        Person(
            "bob.jones@example.com",
            "555-8765",
            "Bob Jones",
            "password789",
            R.drawable.person1
        )
    )
    val addresses = listOf(
        Address(address = "123 Main St", description = "Home", user = persons[0].email),
        Address(address = "456 Oak St", description = "Work", user = persons[0].email),
        Address(address = "789 Pine St", description = "Gym", user = persons[1].email),
        Address(
            address = "321 Maple St",
            description = "Parent's house",
            user = persons[1].email
        ),
        Address(address = "654 Elm St", description = "Vacation home", user = persons[2].email),
        Address(address = "987 Cedar St", description = "Friend's house", user = persons[2].email)
    )
    val foods = listOf(
        Food("Veggie tomato mix", "N1,900", 100, Category.Foods, R.drawable.food_1),
        Food("Egg and cucumber", "N1,900", 200, Category.Drinks, R.drawable.food_2),
        Food("Egg and cucumber", "N1,900", 250, Category.Snacks, R.drawable.food_3),
        Food("Egg and cucumber", "N1,900", 480, Category.Sauce, R.drawable.food_4),
        Food("Egg and cucumber", "N1,900", 100, Category.Foods, R.drawable.food_1),
    )
}



class FakeDataToDBActivity : ComponentActivity() {
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
        if (personViewModel.getAllPersons().isEmpty())
            personViewModel.createListOfUser(FakeData().persons)










        setContent {}
    }
}
