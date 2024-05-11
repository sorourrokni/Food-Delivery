package com.example.fooddelivery.component

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun VerificationCodeField(time:Int):String {
    var number by rememberSaveable { mutableStateOf("") }
    BasicTextField(value = number,
        onValueChange = {
            if(it.length<=6){
                number=it
            }
        }, keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.NumberPassword)
    ) {
        Row(horizontalArrangement = Arrangement.SpaceBetween
        , modifier = Modifier.wrapContentSize(Alignment.Center).fillMaxWidth().padding(start=30.dp,top=0.dp, bottom = 0.dp,end=30.dp)
                    ){
            repeat(time){index->
                val char =when{
                    index>=number.length->""
                    else->number[index].toString()
                }
                Text(modifier = Modifier
                    .width(64.dp)
                    .drawBehind {
                        val strokeWidthPx = 3.dp.toPx()
                        val verticalOffset = size.height
                        drawLine(
                            color = Color(0xffFA4A0C),
                            strokeWidth = strokeWidthPx,
                            start = Offset(0f, verticalOffset),
                            end = Offset(size.width, verticalOffset)
                        )
                    },
                    text = char,
                    style = MaterialTheme.typography.titleSmall.copy(textDecoration = TextDecoration.None)
                , textAlign = TextAlign.Center,
                    )
                Spacer(modifier = Modifier.width(4.dp))

            }
        }
    }
    return number


}