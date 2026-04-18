package com.example.newsapp.data.model

data class Article(
    val id: String,
    val title: String,
    val description: String,
    val category: String,
    val imageUrl: String,
    val isBookmarked: Boolean = false
)
