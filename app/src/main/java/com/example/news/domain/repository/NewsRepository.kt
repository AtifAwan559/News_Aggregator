package com.example.news.domain.repository

import com.example.news.data.model.Article
import kotlinx.coroutines.flow.Flow

interface NewsRepository {
    fun getArticles(): Flow<List<Article>>
    fun getBookmarks(): Flow<List<Article>>
    fun toggleBookmark(article: Article)
    fun isBookmarked(articleId: String): Boolean
}
