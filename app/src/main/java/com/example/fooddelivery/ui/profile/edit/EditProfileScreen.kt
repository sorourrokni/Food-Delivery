package com.example.fooddelivery.ui.profile.edit

import android.util.Log
import android.widget.Space
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.fooddelivery.R
import com.example.fooddelivery.component.FilledButton
import com.example.fooddelivery.component.ProfileTextField
import com.example.fooddelivery.data.Person

@Composable
fun EditProfileScreen (person: Person, modifier: Modifier =Modifier){
    val scrollState = rememberScrollState()

    Column(
        modifier = modifier
            .verticalScroll(scrollState)
            .background(color = MaterialTheme.colorScheme.onSecondary)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(132.dp)
                .padding(start = 40.dp, top = 60.dp, end = 41.dp, bottom = 0.dp)
        ) {
            Image(painter = painterResource(id = R.drawable.chevron_left), contentDescription = null)
            Text("Edit Profile", style = MaterialTheme.typography.titleMedium,modifier=Modifier.padding(start=96.dp))
        }
        Row(modifier = Modifier.padding(start=58.dp,top=20.dp)){
            Text("Information",style=MaterialTheme.typography.headlineSmall.copy(fontSize = 17.sp, lineHeight = 20.sp))
        }
        Spacer(Modifier.height(34.dp))

        Column(modifier=Modifier.padding(start=50.dp)){
            var name by remember { mutableStateOf(person.fullName) }
            var email by remember { mutableStateOf(person.email) }
            var phoneNumber by remember { mutableStateOf(person.phoneNumber) }
            var address by remember { mutableStateOf(person.address) }
            ProfileTextField(label = "Name", type = KeyboardType.Text, base = person.fullName,315,50)
            Spacer(Modifier.height(12.dp))
            ProfileTextField(label = "Email", type = KeyboardType.Text, base = person.email,315,50)
            Spacer(Modifier.height(12.dp))
            ProfileTextField(label = "Phone", type = KeyboardType.Text, base = person.phoneNumber,315,50)
            Spacer(Modifier.height(12.dp))
            ProfileTextField(label = "Address", type = KeyboardType.Text, base = person.address,315,90)
        }
        Spacer(Modifier.height(150.dp))
        FilledButton(onClick = { /*TODO*/ }, text = "Update")
    }
}