package com.example.basicstatecodelab.composables

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.basicstatecodelab.WellnessTask

@Composable
fun WellnessTasksList(
    list: List<WellnessTask>,
    onCloseTask: (WellnessTask) -> Unit,
    modifier: Modifier = Modifier
) {
    LazyColumn(modifier = modifier) {
        items(items = list, key = { task -> task.id }) { task ->
            WellnessTaskItem(
                taskName = task.label,
                onClose = { onCloseTask(task) }
            )

        }

    }
}

// In this problem, we need to uniquely identify tasks based on their ID, not position