package com.example.news.data.local

import com.example.news.data.model.Article
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LocalNewsProvider @Inject constructor(
    private val jsonParser: JsonParser
) {
    private var cachedArticles: MutableList<Article>? = null

    fun getArticles(): List<Article> {
        if (cachedArticles == null) {
            val response = jsonParser.parseNews("news_data.json")
            cachedArticles = response?.articles?.toMutableList() ?: mutableListOf()
        }
        return cachedArticles!!
    }
}
