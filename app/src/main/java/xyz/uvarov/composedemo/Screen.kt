package xyz.uvarov.composedemo

sealed class Screen(val route: String) {
    companion object {
        const val id = "id"
    }

    object List : Screen("list")
    object Detail : Screen("detail/{${id}}")
}