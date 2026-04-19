package com.example.newsapp.ui.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.newsapp.domain.model.Article
import com.example.newsapp.domain.repository.NewsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: NewsRepository
) : ViewModel() {

    private val _searchQuery = MutableStateFlow("")
    val searchQuery: StateFlow<String> = _searchQuery

    val headlines: StateFlow<List<Article>> = repository.getHeadlines()
        .stateIn(viewModelScope, SharingStarted.Lazily, emptyList())

    val trending: StateFlow<List<Article>> = repository.getTrending()
        .stateIn(viewModelScope, SharingStarted.Lazily, emptyList())

    val worldNews: StateFlow<List<Article>> = repository.getArticlesByCategory("World")
        .stateIn(viewModelScope, SharingStarted.Lazily, emptyList())

    val technology: StateFlow<List<Article>> = repository.getArticlesByCategory("Technology")
        .stateIn(viewModelScope, SharingStarted.Lazily, emptyList())

    val opinion: StateFlow<List<Article>> = repository.getArticlesByCategory("Opinion")
        .stateIn(viewModelScope, SharingStarted.Lazily, emptyList())

    val bookmarks: StateFlow<List<Article>> = repository.getBookmarks()
        .stateIn(viewModelScope, SharingStarted.Lazily, emptyList())

    val searchResults: StateFlow<List<Article>> = _searchQuery
        .combine(repository.getHeadlines()) { query, _ ->
            if (query.isBlank()) emptyList()
            else repository.searchArticles(query).stateIn(viewModelScope).value
        }
        .stateIn(viewModelScope, SharingStarted.Lazily, emptyList())

    fun onSearch(query: String) {
        _searchQuery.value = query
    }

    fun toggleBookmark(articleId: String) {
        viewModelScope.launch {
            repository.toggleBookmark(articleId)
        }
    }
}
