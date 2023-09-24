package com.example.basicstatecodelab

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun WaterCounter(modifier: Modifier = Modifier) {

    //Recomposition is re-running composables to update the composition when data changes.
    /* A value calculated by remember is stored in the Composition during the initial composition,
    and the stored value is kept across recompositions. */

    val count: MutableState<Int> = rememberSaveable { mutableStateOf(0) }
    Column(modifier = modifier.padding(16.dp)) {
        if (count.value > 0) {
            /* If we press add button, counter increases to 1 and state changes.
               A recomposition is called, and screen gets recomposed with the new elements
             */

            Text(
                text = "You have counted ${count.value} glasses",
            )
        }

        //adding events to update the state, event -> update state -> display state
        Button(
            onClick = { count.value++ },
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