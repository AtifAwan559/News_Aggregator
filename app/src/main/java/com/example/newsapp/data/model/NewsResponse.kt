package com.example.newsapp.data.model

import com.example.newsapp.domain.model.Article
import kotlinx.serialization.Serializable

@Serializable
data class NewsResponse(
    val articles: List<Article>
)
