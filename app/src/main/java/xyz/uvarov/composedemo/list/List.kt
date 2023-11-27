package xyz.uvarov.composedemo.list

import androidx.compose.foundation.clickable
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import xyz.uvarov.composedemo.Screen

@Composable
fun List(rootNavController: NavController) {
    val viewModel: ListViewModel = viewModel()
    val state by viewModel.state.collectAsState()
    Text(
        text = "List",
        modifier = Modifier.clickable { rootNavController.navigate(Screen.Detail.route) },
    )
}