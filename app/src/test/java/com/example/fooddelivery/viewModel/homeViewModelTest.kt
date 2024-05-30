import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.fooddelivery.data.Food
import com.example.fooddelivery.data.FoodFavorite
import com.example.fooddelivery.data.Order
import com.example.fooddelivery.R
import com.example.fooddelivery.data.Delivery
import com.example.fooddelivery.data.OrderItem
import com.example.fooddelivery.data.PaymentMethod
import com.example.fooddelivery.data.orderStatus
import com.example.fooddelivery.repository.AddressRepository
import com.example.fooddelivery.repository.FoodRepository
import com.example.fooddelivery.repository.OrderItemRepository
import com.example.fooddelivery.repository.OrderRepository
import com.example.fooddelivery.repository.FoodFavRepository
import com.example.fooddelivery.viewModel.HomeViewModel
import io.mockk.coEvery
import io.mockk.mockk
import io.mockk.coVerify
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Assert.assertEquals
import org.junit.Rule
import org.junit.Test

@ExperimentalCoroutinesApi
class HomeViewModelTest {

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    private val foodRepository: FoodRepository = mockk()
    private val foodFavRepository: FoodFavRepository = mockk()
    private val orderRepository: OrderRepository = mockk()
    private val orderItemRepository: OrderItemRepository = mockk()
    private val addressRepository: AddressRepository = mockk()

    private val viewModel = HomeViewModel(
        foodRepository,
        foodFavRepository,
        orderRepository,
        "test@example.com",
        orderItemRepository,
        addressRepository
    )

    @Test
    fun `test getFoodInfo`() = runBlockingTest {
        // Given
        val foodName = "Pizza"
        val expectedFood = Food(foodName, "Delicious Pizza", 1099, R.drawable.food_1)
        coEvery { foodRepository.getFoodInfo(foodName) } returns expectedFood

        // When
        val food = viewModel.getFoodInfo(foodName)

        // Then
        assertEquals(expectedFood, food)
    }

    @Test
    fun `test getAllUserFavoriteFood`() = runBlockingTest {
        // Given
        val email = "test@example.com"
        val expectedFavoriteFoods = listOf(
            Food("Pizza", "Delicious Pizza", 1099, R.drawable.food_1),
            Food("Burger", "Tasty Burger", 899, R.drawable.food_2)
        )
        coEvery { foodFavRepository.getAllUserFavoriteFood(email) } returns flowOf(expectedFavoriteFoods)

        // When
        val favoriteFoods = viewModel.getAllUserFavoriteFood(email)

        // Then
        assertEquals(expectedFavoriteFoods, favoriteFoods)
    }

    // Similarly, you can write tests for other methods like likeFood, disLikeFood, and addToCart.

    @Test
    fun `test likeFood`() = runBlockingTest {
        // Given
        val foodName = "Pizza"
        val userEmail = "test@example.com"
        val foodFavorite = FoodFavorite(foodName, userEmail)

        coEvery { foodFavRepository.userLikeFood(userEmail, foodName) } returns null

        // When
        viewModel.likeFood(foodName)

        // Then
        coVerify { foodFavRepository.insert(foodFavorite) }
    }

    @Test
    fun `test disLikeFood`() = runBlockingTest {
        // Given
        val foodName = "Pizza"
        val userEmail = "test@example.com"
        val foodFavorite = FoodFavorite(foodName, userEmail)

        coEvery { foodFavRepository.userLikeFood(userEmail, foodName) } returns foodFavorite

        // When
        viewModel.disLikeFood(foodName)

        // Then
        coVerify { foodFavRepository.delete(foodFavorite) }
    }

    @Test
    fun `test addToCart`() = runBlockingTest {
        // Given
        val foodName = "Pizza"
        val foodPrice = 1099
        val userEmail = "test@example.com"
        val orderAddressId = 1

        val expectedFood = Food(foodName, "Delicious Pizza", foodPrice, R.drawable.food_1)

        val expectedOrder = Order(1, foodPrice, PaymentMethod.DirectPay, Delivery.PickUp, orderAddressId, userEmail, orderStatus.TODO)
        coEvery { foodRepository.getFoodInfo(foodName) } returns expectedFood
        coEvery { orderRepository.getTODOOrders(userEmail) } returns emptyList()
        coEvery { orderRepository.getAllOrders() } returns emptyList()
        coEvery { orderRepository.upsert(any()) } returns Unit
        coEvery { orderItemRepository.upsert(any()) } returns Unit

        // When
        viewModel.addToCart(foodName)

        // Then
        coVerify { orderRepository.upsert(expectedOrder) }
        coVerify { orderItemRepository.upsert(OrderItem(1, expectedOrder.id, foodName)) }
    }
}
