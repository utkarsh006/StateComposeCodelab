package com.example.basicstatecodelab.composables

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.toMutableStateList
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.basicstatecodelab.WellnessTask
import com.example.basicstatecodelab.WellnessViewModel

@Composable
fun WellnessScreen(
    modifier: Modifier = Modifier,
    wellnessViewModel: WellnessViewModel = viewModel()
) {
    Column(modifier = modifier) {
        StatefulCounter(modifier)

        /* Whenever we add/remove items from our list, toMutableStateList will cause the
        recomposition of our UI */

        val list = remember { getWellnessTasks().toMutableStateList() }
        WellnessTasksList(
            list = wellnessViewModel.tasks,
            onCloseTask = { task ->
                wellnessViewModel.remove(task)

            }
        )
    }

}

private fun getWellnessTasks() = List(30) { i ->
    WellnessTask(i, "Task # $i")
}