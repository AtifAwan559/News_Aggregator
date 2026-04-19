package com.example.newsapp.domain.repository

import com.example.newsapp.domain.model.Article
import kotlinx.coroutines.flow.Flow

interface NewsRepository {
    fun getHeadlines(): Flow<List<Article>>
    fun getArticlesByCategory(category: String): Flow<List<Article>>
    fun getTrending(): Flow<List<Article>>
    fun searchArticles(query: String): Flow<List<Article>>
    fun getBookmarks(): Flow<List<Article>>
    suspend fun toggleBookmark(articleId: String)
}
