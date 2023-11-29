package xyz.uvarov.composedemo.ui.list

import androidx.compose.foundation.clickable
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier

@Composable
fun List(
    viewModel: ListViewModel,
    onItemClick: (id: Int) -> Unit
) {
    val state by viewModel.uiState.collectAsState()
    LaunchedEffect(viewModel) {
        viewModel.updateList()
    }
    LazyColumn {
        items(state.items) { item ->
            Text(text = item.name, Modifier.clickable { onItemClick(item.id) })
        }
    }
}