package com.example.fooddelivery.component

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
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
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomTextField(type: KeyboardType, label: String) {
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