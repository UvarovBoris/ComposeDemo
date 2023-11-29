package xyz.uvarov.composedemo.ui.detail

import androidx.compose.foundation.clickable
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import xyz.uvarov.composedemo.ui.theme.ComposeDemoTheme

@Composable
fun Detail(viewModel: DetailViewModel) {
    val state by viewModel.state.collectAsState()
    Text(
        text = "Detail ${state.counter}",
        modifier = Modifier.clickable {
            viewModel.onCounterClick()
        }
    )
}

@Preview(showBackground = true)
@Composable
fun DetailPreview() {
    ComposeDemoTheme {
        Detail(viewModel())
    }
}