package com.example.fooddelivery.ui.profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.fooddelivery.R
import com.example.fooddelivery.component.ProfileButton
import com.example.fooddelivery.component.ProfileCard
import com.example.fooddelivery.data.Person

@Composable
fun ProfileScreen(person: Person, name:String, modifier: Modifier=Modifier) {

    Column() {
        Row(modifier=Modifier.padding(start = 40.dp,top=60.dp)){
            Image(painterResource(id = R.drawable.chevron_left),null)
        }
        Row(modifier=Modifier.padding(start=54.dp,top=40.dp)){
            Text("My profile",style=MaterialTheme.typography.headlineLarge)
        }
        Row(modifier=Modifier.padding(start=40.dp,top=44.dp), horizontalArrangement = Arrangement.SpaceBetween){
            Text("Personal details",style=MaterialTheme.typography.headlineSmall.copy(fontSize =18.sp, lineHeight = 21.sp))
            Text("change",style=MaterialTheme.typography.bodySmall, color = MaterialTheme.colorScheme.primary,modifier=Modifier.padding(start = 120.dp))
        }
        ProfileCard(person = person,Modifier.padding(start = 42.dp,end=57.dp))
        Spacer(Modifier.height(27.dp))
        ProfileButton(name = "Orders",Modifier.padding(start=42.dp,end=57.dp))
        Spacer(Modifier.height(27.dp))
        ProfileButton(name = "Pending reviews",Modifier.padding(start=42.dp,end=57.dp))
        Spacer(Modifier.height(27.dp))
        ProfileButton(name = "Faq",Modifier.padding(start=42.dp,end=57.dp))
        Spacer(Modifier.height(27.dp))
        ProfileButton(name = "Help",Modifier.padding(start=42.dp,end=57.dp))

    }

}