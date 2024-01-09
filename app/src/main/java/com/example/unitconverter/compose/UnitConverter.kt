package com.example.unitconverter.compose

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.unitconverter.model.Conversion
import com.example.unitconverter.viewmodel.MainViewModel
import java.math.RoundingMode
import java.text.DecimalFormat

@Composable
fun UnitConverter(mainViewModel: MainViewModel = viewModel(), modifier: Modifier) {
    var conversion: MutableState<Conversion?> = remember { mutableStateOf(null) }
    var conversionValue by remember { mutableStateOf<String>("") }
    var message1 by remember { mutableStateOf<String>("") }
    var message2 by remember { mutableStateOf<String>("") }
    val context = LocalContext.current
    Column(
        modifier = modifier.padding(all = 20.dp)
    ) {
        ConversionDropdown(mainViewModel.conversions, modifier) {
            conversion.value = it
        }
        Spacer(modifier = Modifier.height(20.dp))
        conversion.value?.let {
            ConversionInput(it, modifier) { value ->
                if (value.isEmpty()) {
                    Toast.makeText(context, "Please insert value", Toast.LENGTH_LONG).show()
                } else {
                    conversionValue = value
                    // convert here
                    Log.i("UNIT ", value)
                }
            }
        }

        if (conversionValue.isNotEmpty()) {
            conversion.value!!.let { conv ->
                val value = conversionValue.toDouble()
                val multiplier = conv.ratio
                val result = value * multiplier
                val df = DecimalFormat("#.######")
                df.roundingMode = RoundingMode.HALF_UP

                message1 = "$conversionValue ${conv.fromUnit} is equal to"
                message2 = "${df.format(result)} ${conv.toUnit}"

                ConversionResult(message1, message2, modifier)
            }
        }
//        ConversionHistory()
    }

}