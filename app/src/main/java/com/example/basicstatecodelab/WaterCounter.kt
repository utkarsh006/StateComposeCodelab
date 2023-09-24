package com.example.basicstatecodelab

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun WaterCounter(modifier: Modifier = Modifier) {
    val count = 0;
    Text(
        text = "You have counted $count glasses",
        modifier.padding(16.dp)
    )
}

@Preview(showBackground = true)
@Composable
fun WaterCounterPreview() {
    WaterCounter()
}