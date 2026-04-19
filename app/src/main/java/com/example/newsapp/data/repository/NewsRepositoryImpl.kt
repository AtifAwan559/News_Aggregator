package com.example.newsapp.data.repository

import com.example.newsapp.data.source.NewsDataSource
import com.example.newsapp.domain.model.Article
import com.example.newsapp.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.update
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class NewsRepositoryImpl @Inject constructor(
    private val dataSource: NewsDataSource
) : NewsRepository {

    private val _articles = MutableStateFlow<List<Article>>(emptyList())

    init {
        _articles.value = dataSource.getArticles()
    }

    override fun getHeadlines(): Flow<List<Article>> = _articles.map { it.take(5) }

    override fun getArticlesByCategory(category: String): Flow<List<Article>> = _articles.map { list ->
        if (category == "All") list else list.filter { it.category.equals(category, ignoreCase = true) }
    }

    override fun getTrending(): Flow<List<Article>> = _articles.map { it.filter { article -> article.isTrending } }

    override fun searchArticles(query: String): Flow<List<Article>> = _articles.map { list ->
        list.filter { it.title.contains(query, ignoreCase = true) || it.content.contains(query, ignoreCase = true) }
    }

    override fun getBookmarks(): Flow<List<Article>> = _articles.map { it.filter { article -> article.isBookmarked } }

    override suspend fun toggleBookmark(articleId: String) {
        _articles.update { currentList ->
            currentList.map {
                if (it.id == articleId) it.copy(isBookmarked = !it.isBookmarked) else it
            }
        }
    }
}
