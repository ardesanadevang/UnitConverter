package com.example.unitconverter.ui.compose

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.unitconverter.data.model.ConversionResult

@Composable
fun ConversionHistory(
    conversationHistories: State<List<ConversionResult>>,
    modifier: Modifier,
    onCloseTask: (ConversionResult) -> Unit,
    onDeleteAll: () -> Unit
) {
    Column(modifier = modifier.fillMaxWidth()) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = modifier.fillMaxWidth()
        ) {
            Text(text = "History", fontSize = 28.sp, fontWeight = FontWeight.Bold)
            OutlinedButton(
                onClick = { onDeleteAll() },
            ) {
                Text(text = "Clear All", color = Color.Gray)
            }
        }
        Spacer(modifier = modifier.height(10.dp))
        LazyColumn(modifier = modifier.fillMaxWidth()) {
            items(
                items = conversationHistories.value,
                key = { item -> item.id }
            ) { item ->
                ConversionHistoryItem(
                    message1 = item.message1,
                    message2 = item.message2,
                    onClose = { onCloseTask(item) },
                    modifier = modifier
                )
            }
        }

    }
}