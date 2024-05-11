package com.example.fooddelivery.ui.auth.forgotpassword

import android.content.res.Resources.Theme
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicText
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import com.example.fooddelivery.R

@Composable
fun ForgotPasswordScreen(name:String,modifier: Modifier=Modifier) {
    val scrollState = rememberScrollState()
    Column(
        modifier = Modifier
            .verticalScroll(scrollState)
            .background(color = MaterialTheme.colorScheme.onSecondary)
    ) {
        Box(
            modifier = Modifier
                .height(382.dp)
                .fillMaxWidth()
                .padding(bottom = 64.dp)
                .background(
                    color = MaterialTheme.colorScheme.onPrimary,
                    shape = RoundedCornerShape(30.dp).copy(
                        topStart = CornerSize(0.dp),
                        topEnd = CornerSize(0.dp)
                    )
                )
        )
        {
            Column (modifier= Modifier
                .padding(start = 0.dp, top = 0.dp, end = 0.dp, bottom = 0.dp)
                .align(Alignment.Center)
                .wrapContentSize(Alignment.Center)

            ){
            Image(
                painter = painterResource(id = R.drawable.lock),
                contentDescription = null,
                modifier = Modifier
//                    .align(Alignment.Center)
                    .size(164.16.dp, 164.16.dp)
                    .padding(start = 0.dp, top = 32.dp, end = 0.dp, bottom = 0.dp)
            )

                Text(text = "\nForgot Password", style = MaterialTheme.typography.titleMedium, color = Color(0xffFA4A0C)
                ,modifier=Modifier.padding(start=8.dp)
                )


                Text(text = "Enter your registered email", style = MaterialTheme.typography.labelLarge,modifier=Modifier.padding(8.dp))

            }
        }
        TextField(KeyboardType.Email, label = "Email address")

        Spacer(modifier = Modifier.height(280.dp))

        FilledButton(onClick = { /*TODO*/ }, text = "Enter code")

    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TextField(type: KeyboardType, label: String) {
    var text by rememberSaveable { mutableStateOf("") }

    TextField(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 50.dp, top = 0.dp, end = 50.dp, bottom = 0.dp)
            .height(59.dp),
        value = text,
        onValueChange = { text = it },
        textStyle = MaterialTheme.typography.titleSmall.copy(textDecoration = TextDecoration.None),
        label = {
            Text(
                text = label,
                style = MaterialTheme.typography.bodySmall
            )
        },
        visualTransformation = if (type == KeyboardType.Password) PasswordVisualTransformation() else VisualTransformation.None,
        keyboardOptions = KeyboardOptions(keyboardType = type),
        colors = TextFieldDefaults.textFieldColors(
            textColor = Color.Black,
            containerColor = MaterialTheme.colorScheme.onSecondary,
            cursorColor = Color.Black,
            focusedIndicatorColor = Color.Black.copy(alpha = 0.5f),
            unfocusedIndicatorColor = Color.Black,
            focusedLabelColor = Color.Gray,
        )
    )
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
