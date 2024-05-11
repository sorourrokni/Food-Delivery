package com.example.fooddelivery.component

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


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
