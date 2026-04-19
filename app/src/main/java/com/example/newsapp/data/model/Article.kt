package com.example.newsapp.data.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Article(
    val id: String = "",
    val title: String = "",
    val description: String = "",
    val category: String = "",
    val imageUrl: String = "",
    val publishedAt: String = "24 May 2024",
    val content: String = "",
    val author: String = "Al Jazeera Staff",
    val isBookmarked: Boolean = false
) : Parcelable
