package com.example.newsapp.data.source

import android.content.Context
import android.util.Log
import com.example.newsapp.data.model.NewsResponse
import com.example.newsapp.domain.model.Article
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.serialization.json.Json
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class NewsDataSource @Inject constructor(
    @ApplicationContext private val context: Context
) {
    private val json = Json { 
        ignoreUnknownKeys = true 
        coerceInputValues = true
    }

    fun getArticles(): List<Article> {
        return try {
            val jsonString = context.assets.open("news.json").bufferedReader().use { it.readText() }
            val response = json.decodeFromString<NewsResponse>(jsonString)
            Log.d("NewsDataSource", "Total articles loaded: ${response.articles.size}")
            response.articles.forEach { 
                Log.d("NewsDataSource", "Article: ${it.title}, Trending: ${it.isTrending}")
            }
            response.articles
        } catch (e: Exception) {
            Log.e("NewsDataSource", "Error loading articles", e)
            emptyList()
        }
    }
}
