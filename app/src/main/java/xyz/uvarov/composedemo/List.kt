package xyz.uvarov.composedemo

import androidx.compose.foundation.clickable
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController

@Composable
fun List(rootNavController: NavController, modifier: Modifier = Modifier) {
    Text(
        text = "List",
        modifier = modifier.clickable { rootNavController.navigate(Screen.Detail.route) },
    )
}