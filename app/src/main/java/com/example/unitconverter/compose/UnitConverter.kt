package com.example.unitconverter.compose

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.unitconverter.model.Conversion
import com.example.unitconverter.viewmodel.MainViewModel

@Composable
fun UnitConverter(mainViewModel: MainViewModel = viewModel(), modifier: Modifier) {
    var conversion: MutableState<Conversion?> = remember { mutableStateOf(null) }

    Column(
        modifier = modifier.padding(all = 10.dp)
    ) {
        ConversionDropdown(mainViewModel.conversions, modifier) {
            conversion.value = it
        }
        Spacer(modifier = Modifier.height(20.dp))
        conversion.value?.let {
            ConversionInput(it, modifier) { value ->
                Log.d("value", value.toString())
            }
        }
        ConversionHistory()
    }

}