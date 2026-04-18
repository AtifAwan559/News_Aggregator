package com.example.news.model

data class Article(
    val id: Int,
    val title: String,
    val description: String,
    val content: String,
    val category: String,
    val imageUrl: String,
    val publishedAt: String
)
