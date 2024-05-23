package com.example.fooddelivery.navigation

import com.example.fooddelivery.R
import com.example.fooddelivery.data.Address
import com.example.fooddelivery.data.Category
import com.example.fooddelivery.data.Delivery
import com.example.fooddelivery.data.Food
import com.example.fooddelivery.data.Payment
import com.example.fooddelivery.data.PaymentMethod
import com.example.fooddelivery.data.Person

class FakeData {
    val persons = generateHardcodedPersonData()
    val person1 = generateHardcodedPersonData().first()

    val address1 = generateHardcodedAddressData(persons).first()
    val addresses = generateHardcodedAddressData(persons)

    val food1 = generateHardcodedFoodData()[0]
    val food2 = generateHardcodedFoodData()[1]
    val food3 = generateHardcodedFoodData()[2]
    val foods = generateHardcodedFoodData()

    val payment1 = Payment(
        foodsList = linkedMapOf(
            food1 to 2,
            food2 to 1,
            food3 to 3
        ),
        totalPrice = 2 * food1.price + 1 * food2.price + 3 * food3.price,
        address = address1,
        delivery = Delivery.PickUp,
        paymentMethod = PaymentMethod.Card,
        person = person1
    )

    val payments = listOf(payment1, payment1, payment1)

    private fun generateHardcodedPersonData(): List<Person> {
        return listOf(
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
    }

    private fun generateHardcodedAddressData(users: List<Person>): List<Address> {
        return listOf(
            Address(address = "123 Main St", description = "Home", user = users[0].email),
            Address(address = "456 Oak St", description = "Work", user = users[0].email),
            Address(address = "789 Pine St", description = "Gym", user = users[1].email),
            Address(
                address = "321 Maple St",
                description = "Parent's house",
                user = users[1].email
            ),
            Address(address = "654 Elm St", description = "Vacation home", user = users[2].email),
            Address(address = "987 Cedar St", description = "Friend's house", user = users[2].email)
        )
    }

    private fun generateHardcodedFoodData(): List<Food> {
        return listOf(
            Food("Veggie tomato mix", "N1,900", 100, Category.Foods, R.drawable.food_1),
            Food("Egg and cucumber", "N1,900", 200, Category.Drinks, R.drawable.food_2),
            Food("Egg and cucumber", "N1,900", 250, Category.Snacks, R.drawable.food_3),
            Food("Egg and cucumber", "N1,900", 480, Category.Sauce, R.drawable.food_4),
            Food("Egg and cucumber", "N1,900", 100, Category.Foods, R.drawable.food_1),
        )
    }
}