package com.example.fooddelivery.ui.auth.lostconnection

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.fooddelivery.R

@Composable
fun LostConnectionScreen(name :String , modifier:Modifier=Modifier) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier= Modifier
            .wrapContentSize(Alignment.Center)
            .fillMaxSize()){
        Image(painterResource(id = R.drawable.eva_wifi_off_fill ),null,
            modifier=Modifier.padding(top=251.dp))
        Text("No internet Connection", style = MaterialTheme.typography.bodyLarge, lineHeight = 32.81.sp)
        Text("Your internet connection is currently\n" +
                "not available please check or try again.",style=MaterialTheme.typography.bodyMedium, fontSize = 17.sp, lineHeight = 19.92.sp
        ,modifier=Modifier.padding(top=10.dp))
        Spacer(modifier = Modifier.height(50.dp))

        FilledButton(onClick = { /*TODO*/ }, text = "Try agin")
    }
}



@Composable
fun FilledButton(onClick: () -> Unit, text: String) {
    Button(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 50.dp, top = 0.dp, end = 50.dp, bottom = 42.dp),
        onClick = { onClick() },
        colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.primary)
    ) {
        Text(
            modifier = Modifier.padding(start = 0.dp, top = 12.dp, end = 0.dp, bottom = 12.dp),
            text = text,
            style = MaterialTheme.typography.titleSmall.copy(color = MaterialTheme.colorScheme.secondary)
        )
    }
}
