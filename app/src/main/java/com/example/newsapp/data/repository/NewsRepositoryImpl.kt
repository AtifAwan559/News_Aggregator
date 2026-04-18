package com.example.newsapp.data.repository

import com.example.newsapp.data.local.LocalNewsProvider
import com.example.newsapp.data.model.Article
import com.example.newsapp.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.update
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class NewsRepositoryImpl @Inject constructor(
    private val localNewsProvider: LocalNewsProvider
) : NewsRepository {

    private val _articles = MutableStateFlow<List<Article>>(emptyList())
    private val articles = _articles.asStateFlow()

    init {
        _articles.value = localNewsProvider.getArticles()
    }

    override fun getAllNews(): Flow<List<Article>> = articles

    override fun getNewsByCategory(category: String): Flow<List<Article>> {
        return articles.map { list ->
            if (category.equals("All", ignoreCase = true)) {
                list
            } else {
                list.filter { it.category.equals(category, ignoreCase = true) }
            }
        }
    }

    override fun searchNews(query: String): Flow<List<Article>> {
        return articles.map { list ->
            if (query.isBlank()) {
                list
            } else {
                list.filter {
                    it.title.contains(query, ignoreCase = true) ||
                            it.description.contains(query, ignoreCase = true)
                }
            }
        }
    }

    override fun toggleBookmark(articleId: String): Flow<Unit> = flow {
        _articles.update { currentList ->
            currentList.map { article ->
                if (article.id == articleId) {
                    article.copy(isBookmarked = !article.isBookmarked)
                } else {
                    article
                }
            }
        }
        emit(Unit)
    }

    override fun getBookmarkedNews(): Flow<List<Article>> {
        return articles.map { list ->
            list.filter { it.isBookmarked }
        }
    }
}
