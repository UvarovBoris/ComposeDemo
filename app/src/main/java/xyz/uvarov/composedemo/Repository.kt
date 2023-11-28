package xyz.uvarov.composedemo

import javax.inject.Inject

interface Repository {
}

class RepositoryImpl @Inject constructor() : Repository {
}