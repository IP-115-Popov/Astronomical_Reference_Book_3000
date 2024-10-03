package ru.sergey.astronomicalreferencebook3000.presentation.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ru.sergey.damain.repository.NewsRepository
import ru.sergey.data.repository.NewsRepositoryImp
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class DataModule {
    @Provides
    @Singleton
    fun provideNewsRepository() : NewsRepository {
        return NewsRepositoryImp()
    }
}