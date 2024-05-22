package com.example.fooddelivery.ui.profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.fooddelivery.R
import com.example.fooddelivery.component.ProfileButton
import com.example.fooddelivery.component.ProfileCard
import com.example.fooddelivery.data.Address
import com.example.fooddelivery.data.Person
import com.example.fooddelivery.navigation.NavControllerWithHistory
import com.example.fooddelivery.navigation.Screen

@Composable
fun ProfileScreen(
    person: Person,
    name: String,
    modifier: Modifier = Modifier,
    address: Address,
    navControllerWithHistory: NavControllerWithHistory
) {
    val scrollState = rememberScrollState()

    Column(
        modifier = modifier
            .verticalScroll(scrollState)
            .background(color = MaterialTheme.colorScheme.onSecondary)
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
                .height(132.dp)
                .padding(start = 54.dp, top = 74.dp, end = 41.dp, bottom = 0.dp)
        ) {
            Image(painter = painterResource(id = R.drawable.ic_more), contentDescription = null)
            Image(
                painter = painterResource(id = R.drawable.ic_shopping_cart),
                contentDescription = null
            )
        }
        Row(
            modifier = Modifier
                .padding(start = 54.dp, top = 0.dp, end = 41.dp, bottom = 0.dp)
                .fillMaxWidth(), horizontalArrangement = Arrangement.Start
        ) {
            Text("My profile", style = MaterialTheme.typography.headlineLarge)
        }
        Row(
            modifier = Modifier
                .padding(start = 42.dp, top = 44.dp, bottom = 12.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            Text(
                "Personal details",
                style = MaterialTheme.typography.headlineSmall.copy(
                    fontSize = 18.sp,
                    lineHeight = 21.sp
                )
            )
            Text(
                modifier = Modifier
                    .padding(end = 57.dp)
                    .clickable { navControllerWithHistory.navigate(Screen.EditProfile.route) },
                text = "change",
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.primary,
            )
        }
        ProfileCard(
            person = person,
            Modifier.padding(start = 42.dp, end = 57.dp),
            address = address
        )
        Spacer(Modifier.height(27.dp))
        ProfileButton(name = "Orders", Modifier.padding(start = 42.dp, end = 57.dp))
        Spacer(Modifier.height(27.dp))
        ProfileButton(name = "Pending reviews", Modifier.padding(start = 42.dp, end = 57.dp))
        Spacer(Modifier.height(27.dp))
        ProfileButton(name = "Faq", Modifier.padding(start = 42.dp, end = 57.dp))
        Spacer(Modifier.height(27.dp))
        ProfileButton(name = "Help", Modifier.padding(start = 42.dp, end = 57.dp))

    }

}