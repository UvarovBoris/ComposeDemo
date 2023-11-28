package xyz.uvarov.composedemo.list

import androidx.compose.foundation.clickable
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun List(
    viewModel: ListViewModel = viewModel(),
    onItemSelected: () -> Unit
) {
    val state by viewModel.state.collectAsState()
    Text(
        text = "List",
        modifier = Modifier.clickable { onItemSelected() },
    )
}