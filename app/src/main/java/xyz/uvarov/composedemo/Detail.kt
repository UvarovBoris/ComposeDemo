package xyz.uvarov.composedemo

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import xyz.uvarov.composedemo.ui.theme.ComposeDemoTheme

@Composable
fun Detail(modifier: Modifier = Modifier) {
    Text(
        text = "Detail",
        modifier = modifier,
    )
}

@Preview(showBackground = true)
@Composable
fun DetailPreview() {
    ComposeDemoTheme {
        Detail()
    }
}