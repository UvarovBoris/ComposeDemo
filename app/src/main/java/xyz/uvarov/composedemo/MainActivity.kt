package xyz.uvarov.composedemo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import xyz.uvarov.composedemo.ui.theme.ComposeDemoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeDemoTheme {
                val rootNavController = rememberNavController()
                NavHost(navController = rootNavController, startDestination = Screen.List.route) {
                    composable(Screen.List.route) { List(rootNavController) }
                    composable(Screen.Detail.route) { Detail() }
                }
            }
        }
    }
}

sealed class Screen(val route: String) {
    object List : Screen("list")
    object Detail : Screen("detail")
}