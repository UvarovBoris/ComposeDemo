package xyz.uvarov.composedemo.ui.detail

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue

@Composable
fun Detail(viewModel: DetailViewModel) {
    val uiState by viewModel.uiState.collectAsState()
    uiState.item?.let {
        Text(text = it.name)
    }
}