package com.example.basicstatecodelab

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

//Recomposition is re-running composables to update the composition when data changes.

/* A value calculated by remember is stored in the Composition during the initial composition,
and the stored value is kept across recompositions. */

@Composable
fun StatefulCounter(modifier: Modifier = Modifier) {
    val count: MutableState<Int> = rememberSaveable { mutableStateOf(0) }
    StatelessCounter(onIncrement = { count.value++ }, count = count.value)
}
//state going down, events going up, Unidirectional Data Flow (UDF)

@Composable
fun StatelessCounter(
    modifier: Modifier = Modifier,
    onIncrement: () -> Unit,
    count: Int
) {
    Column(modifier = modifier.padding(16.dp)) {
        if (count > 0) {
            /* If we press add button, counter increases to 1 and state changes.
               A recomposition is called, and screen gets recomposed with the new elements
             */

            Text(
                text = "You have counted $count glasses",
            )
        }

        //adding events to update the state, event -> update state -> display state
        Button(
            onClick = onIncrement,
            Modifier.padding(top = 8.dp)
        ) {
            Text("Add One")
        }
    }
}
