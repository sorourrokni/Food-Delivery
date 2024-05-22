package com.example.fooddelivery.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.fooddelivery.data.Address
import com.example.fooddelivery.data.Person

@Composable
fun ProfileCard(person: Person, modifier: Modifier, address: Address) {
    Row(
        modifier
            .background(color = Color.White, shape = RoundedCornerShape(20.dp))
    ) {
        Image(
            modifier = Modifier
                .size(91.dp, 100.dp)
                .fillMaxHeight()
                .padding(start = 16.dp, top = 18.dp),
            painter = painterResource(id = person.profileImg),
            contentDescription = null,
        )
        Column(
            modifier = Modifier.padding(
                start = 16.dp,
                top = 24.dp,
                end = 24.dp,
                bottom = 24.dp
            )
        ) {
            Text(
                person.fullName, style = MaterialTheme.typography.headlineSmall.copy(
                    fontSize = 18.sp, lineHeight = 21.sp
                ), modifier = Modifier.padding(bottom = 6.dp)
            )
            Text(
                person.email,
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onPrimaryContainer
            )
            Divider(
                modifier = Modifier.padding(top = 8.dp, bottom = 8.dp),
                color = Color.Black,
                thickness = 0.5.dp
            )
            Text(
                person.phoneNumber,
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onPrimaryContainer
            )
            Divider(
                modifier = Modifier.padding(top = 8.dp, bottom = 8.dp),
                color = Color.Black,
                thickness = 0.5.dp
            )
            Text(
                address.address,
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onPrimaryContainer
            )

        }
    }
}