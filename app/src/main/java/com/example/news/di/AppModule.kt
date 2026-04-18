package com.example.news.di

import com.example.news.data.local.LocalNewsProvider
import com.example.news.data.repository.NewsRepositoryImpl
import com.example.news.domain.repository.NewsRepository
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideGson(): Gson = Gson()

    @Provides
    @Singleton
    fun provideNewsRepository(
        localNewsProvider: LocalNewsProvider
    ): NewsRepository {
        return NewsRepositoryImpl(localNewsProvider)
    }
}
