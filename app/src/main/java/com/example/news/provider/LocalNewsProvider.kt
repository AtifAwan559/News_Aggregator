package com.example.news.provider

import com.example.news.model.Article
import com.example.news.util.JsonParser
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LocalNewsProvider @Inject constructor(private val jsonParser: JsonParser) {
    private var cachedArticles: ArrayList<Article> = ArrayList()

    fun getArticles(): List<Article> {
        if (cachedArticles.isEmpty()) {
            val response = jsonParser.getNewsFromJson("news_metadata.json")
            response?.let {
                cachedArticles.addAll(it.articles)
            }
        }
        return cachedArticles
    }
}
