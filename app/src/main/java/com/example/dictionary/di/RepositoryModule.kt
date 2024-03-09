package com.example.dictionary.di

import com.ahmed_apps.dictionary_app.data.repository.DictRepositoryImpl
import com.example.dictionary.domain.repository.DictRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    @Singleton
    abstract fun bindDictRepository(
        dictionaryRepositoryImpl: DictRepositoryImpl
    ): DictRepository
}















