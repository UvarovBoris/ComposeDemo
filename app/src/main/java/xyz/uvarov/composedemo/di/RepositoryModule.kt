package xyz.uvarov.composedemo.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import xyz.uvarov.data.Repository
import xyz.uvarov.data.RepositoryImpl
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun provideRepository(): Repository {
        return RepositoryImpl()
    }
}