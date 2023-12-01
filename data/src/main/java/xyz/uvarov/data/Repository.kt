package xyz.uvarov.data

import kotlinx.coroutines.delay

interface Repository {
    suspend fun getItems(): List<Item>
    suspend fun getItem(id: Int): Item?
}

class RepositoryImpl() : Repository {

    companion object {
        val items = listOf(
            Item(0, "0"),
            Item(1, "1"),
            Item(2, "2"),
            Item(3, "3"),
            Item(4, "4"),
            Item(5, "5"),
            Item(6, "6"),
            Item(7, "7"),
            Item(8, "8")
        )
    }

    override suspend fun getItems(): List<Item> {
        delay(1000)
        return items
    }

    override suspend fun getItem(id: Int): Item? {
        return getItems().find { it.id == id }
    }
}