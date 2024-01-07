package com.example.unitconverter.compose

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.unitconverter.model.Conversion

@Composable
fun ConversionInput(conversion: Conversion, modifier: Modifier, onUnitAdded: (Float) -> Unit) {
    var textValue by remember { mutableStateOf<String>("") }
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier.fillMaxWidth()
    ) {
        TextField(
            value = textValue,
            onValueChange = {
                textValue = it
            },
            modifier = modifier.fillMaxWidth(0.75f),
            keyboardOptions = KeyboardOptions(
                KeyboardCapitalization.None,
                true,
                KeyboardType.Number,
                ImeAction.Go
            ),
            textStyle = TextStyle(
                color = Color.DarkGray,
                fontSize = 30.sp
            )
        )
        Spacer(modifier = modifier.width(20.dp))

        Text(
            text = conversion.fromUnit,
            textAlign = TextAlign.Center
        )
    }
}