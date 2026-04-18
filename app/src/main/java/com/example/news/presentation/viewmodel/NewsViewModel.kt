package com.example.news.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.news.data.model.Article
import com.example.news.domain.repository.NewsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NewsViewModel @Inject constructor(
    private val repository: NewsRepository
) : ViewModel() {

    private val _searchQuery = MutableStateFlow("")
    private val _selectedCategory = MutableStateFlow("All")

    private val _allArticles = MutableStateFlow<List<Article>>(emptyList())
    val allArticles: StateFlow<List<Article>> = _allArticles.asStateFlow()

    val bookmarks: StateFlow<List<Article>> = repository.getBookmarks()
        .stateIn(viewModelScope, SharingStarted.Lazily, emptyList())

    @OptIn(FlowPreview::class)
    val filteredArticles: StateFlow<List<Article>> = combine(
        _allArticles,
        _searchQuery.debounce(300),
        _selectedCategory
    ) { articles, query, category ->
        articles.filter { article ->
            val matchesCategory = if (category == "All") true else article.category.equals(category, ignoreCase = true)
            val matchesQuery = article.title.contains(query, ignoreCase = true) ||
                    article.description.contains(query, ignoreCase = true)
            matchesCategory && matchesQuery
        }
    }.stateIn(viewModelScope, SharingStarted.Lazily, emptyList())

    init {
        loadArticles()
    }

    private fun loadArticles() {
        viewModelScope.launch {
            repository.getArticles().collect { articles ->
                _allArticles.value = articles
            }
        }
    }

    fun onSearchQueryChanged(query: String) {
        _searchQuery.value = query
    }

    fun onCategorySelected(category: String) {
        _selectedCategory.value = category
    }

    fun toggleBookmark(article: Article) {
        repository.toggleBookmark(article)
    }
}
