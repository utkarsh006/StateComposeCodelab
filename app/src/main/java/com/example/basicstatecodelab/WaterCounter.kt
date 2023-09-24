package com.example.basicstatecodelab

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun WaterCounter(modifier: Modifier = Modifier) {
    var count = 0;
    Column(modifier = modifier.padding(16.dp)) {
        Text(
            text = "You have counted $count glasses",
        )

        //adding events to update the state, event -> update state -> display state
        Button(
            onClick = { count++ },
            Modifier.padding(top = 8.dp)
        ) {
            Text("Add One")
        }
    }

}

@Preview(showBackground = true)
@Composable
fun WaterCounterPreview() {
    WaterCounter()
}