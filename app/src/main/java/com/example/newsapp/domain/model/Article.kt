package com.example.newsapp.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.Serializable

@Serializable
@Parcelize
data class Article(
    val id: String = "",
    val title: String = "",
    val summary: String = "",
    val content: String = "",
    val imageUrl: String = "",
    val author: String = "Al Jazeera Staff",
    val publishedAt: String = "",
    val category: String = "News",
    val isTrending: Boolean = false,
    val isBookmarked: Boolean = false
) : Parcelable
