package com.example.newsapp.di

import android.content.Context
import com.example.newsapp.data.local.LocalNewsProvider
import com.example.newsapp.data.repository.NewsRepositoryImpl
import com.example.newsapp.domain.repository.NewsRepository
import com.example.newsapp.utils.JsonParser
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
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
    fun provideJsonParser(@ApplicationContext context: Context, gson: Gson): JsonParser {
        return JsonParser(context, gson)
    }

    @Provides
    @Singleton
    fun provideLocalNewsProvider(jsonParser: JsonParser): LocalNewsProvider {
        return LocalNewsProvider(jsonParser)
    }

    @Provides
    @Singleton
    fun provideNewsRepository(localNewsProvider: LocalNewsProvider): NewsRepository {
        return NewsRepositoryImpl(localNewsProvider)
    }
}
