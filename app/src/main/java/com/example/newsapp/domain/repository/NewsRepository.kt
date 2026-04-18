package com.example.newsapp.domain.repository

import com.example.newsapp.data.model.Article
import kotlinx.coroutines.flow.Flow

interface NewsRepository {
    fun getAllNews(): Flow<List<Article>>
    fun getNewsByCategory(category: String): Flow<List<Article>>
    fun searchNews(query: String): Flow<List<Article>>
    fun toggleBookmark(articleId: String): Flow<Unit>
    fun getBookmarkedNews(): Flow<List<Article>>
}
