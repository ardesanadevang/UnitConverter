package com.example.unitconverter.ui.compose

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ConversionResult(message1: String, message2: String, modifier: Modifier) {

    Card(
        elevation = CardDefaults.cardElevation(defaultElevation = 10.dp),
    ) {
        Column(
            horizontalAlignment = Alignment.Start,
            modifier = modifier.padding(10.dp)
        ) {
            Text(
                text = message1,
                fontSize = 20.sp
            )
            Text(
                text = message2,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Blue
            )
        }
    }

}