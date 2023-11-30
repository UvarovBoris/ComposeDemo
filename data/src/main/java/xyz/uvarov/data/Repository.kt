package xyz.uvarov.data

interface Repository {
    suspend fun getItems(): List<Item>
    suspend fun getItem(id: Int): Item?
}

class RepositoryImpl() : Repository {

    companion object {
        val items = listOf(
            Item(0, "Anna"),
            Item(1, "James"),
            Item(2, "Kris")
        )
    }

    override suspend fun getItems(): List<Item> {
//        delay(1000)
        return items
    }

    override suspend fun getItem(id: Int): Item? {
        return getItems().find { it.id == id }
    }
}