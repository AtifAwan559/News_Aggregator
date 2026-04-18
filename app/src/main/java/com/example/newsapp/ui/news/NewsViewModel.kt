package com.example.newsapp.ui.news

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.newsapp.data.model.Article
import com.example.newsapp.domain.repository.NewsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
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

    val newsList: StateFlow<List<Article>> = repository.getAllNews()
        .stateIn(viewModelScope, SharingStarted.Lazily, emptyList())

    @OptIn(FlowPreview::class)
    val filteredList: StateFlow<List<Article>> = combine(
        newsList,
        _searchQuery.debounce(300),
        _selectedCategory
    ) { list, query, category ->
        list.filter { article ->
            val matchesCategory = if (category == "All") true else article.category.equals(category, ignoreCase = true)
            val matchesQuery = article.title.contains(query, ignoreCase = true) ||
                    article.description.contains(query, ignoreCase = true)
            matchesCategory && matchesQuery
        }
    }.flowOn(Dispatchers.Default)
        .stateIn(viewModelScope, SharingStarted.Lazily, emptyList())

    val bookmarks: StateFlow<List<Article>> = repository.getBookmarkedNews()
        .stateIn(viewModelScope, SharingStarted.Lazily, emptyList())

    fun onSearch(query: String) {
        _searchQuery.value = query
    }

    fun onCategorySelected(category: String) {
        _selectedCategory.value = category
    }

    fun toggleBookmark(article: Article) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.toggleBookmark(article.id).collect()
        }
    }
}
