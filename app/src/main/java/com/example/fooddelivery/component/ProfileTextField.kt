package com.example.fooddelivery.component

import android.widget.Space
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
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
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileTextField(label:String,type:KeyboardType,base:String) {
    var text by rememberSaveable { mutableStateOf(base) }
    Column(){

        Text(
            text = label,
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Start,
            style = MaterialTheme.typography.titleMedium.copy(fontSize = 14.sp, lineHeight = 16.41.sp)
        )
        Spacer(modifier = Modifier.height(6.dp))

        OutlinedTextField(
            value = text,
            onValueChange = {
                text = it
            },
            textStyle = MaterialTheme.typography.bodySmall.copy(lineHeight = 17.58.sp),
            placeholder = { Text(text = base,style=MaterialTheme.typography.bodySmall,color=Color(0xffADADAF
            ), lineHeight = 17.58.sp) },
            keyboardOptions = KeyboardOptions(keyboardType = type),

            shape = RoundedCornerShape(16.dp),
                colors = TextFieldDefaults.textFieldColors(
                    textColor = Color.Black,
                    containerColor = MaterialTheme.colorScheme.onSecondary,
                    cursorColor = Color.Black,
                    focusedIndicatorColor = Color.Black.copy(alpha = 0.5f),
                    unfocusedIndicatorColor = Color.Gray,
                    focusedLabelColor = Color.Gray,
                    disabledIndicatorColor = Color.Transparent
                )
            , modifier =Modifier.border(BorderStroke(1.dp,Color.Black),shape = RoundedCornerShape(16.dp))
                .size(315.dp,50.dp)

        )
    }

}