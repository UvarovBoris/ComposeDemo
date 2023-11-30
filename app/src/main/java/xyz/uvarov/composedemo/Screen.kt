package xyz.uvarov.composedemo

sealed class Screen {
    abstract val name: String
    abstract val route: String

    object List : Screen() {
        override val name: String = "list"
        override val route: String = name
    }

    object Detail : Screen() {
        const val id = "id"
        override val name: String = "detail"
        override val route: String = "${name}/{${id}}"
        fun navigate(id: Int): String = "${name}/${id}"
    }
}