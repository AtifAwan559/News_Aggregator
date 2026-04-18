package com.example.news.data.repository

import com.example.news.data.local.LocalNewsProvider
import com.example.news.data.model.Article
import com.example.news.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.update
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class NewsRepositoryImpl @Inject constructor(
    private val localNewsProvider: LocalNewsProvider
) : NewsRepository {

    private val _bookmarks = MutableStateFlow<List<Article>>(emptyList())
    private val bookmarks: Flow<List<Article>> = _bookmarks

    override fun getArticles(): Flow<List<Article>> = flow {
        emit(localNewsProvider.getArticles())
    }

    override fun getBookmarks(): Flow<List<Article>> = bookmarks

    override fun toggleBookmark(article: Article) {
        _bookmarks.update { currentBookmarks ->
            if (currentBookmarks.any { it.id == article.id }) {
                currentBookmarks.filterNot { it.id == article.id }
            } else {
                currentBookmarks + article
            }
        }
    }

    override fun isBookmarked(articleId: String): Boolean {
        return _bookmarks.value.any { it.id == articleId }
    }
}
