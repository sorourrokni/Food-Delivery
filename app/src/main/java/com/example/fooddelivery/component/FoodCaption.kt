package com.example.fooddelivery.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun FoodCaption(title: String, caption: String, modifier: Modifier = Modifier) {
Column {
    Text(
        text = title,
        style = MaterialTheme.typography.headlineSmall.copy(fontSize = 17.sp),
        textAlign = TextAlign.Start,
        modifier = Modifier.fillMaxWidth()
            .padding(bottom = 8.dp)
    )
    Text(
        text = caption,
        style = MaterialTheme.typography.bodySmall,
        textAlign = TextAlign.Start,
        modifier = Modifier.fillMaxWidth()
    )
}
}