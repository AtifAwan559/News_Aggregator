package com.example.newsapp.data.local

import com.example.newsapp.data.model.Article
import com.example.newsapp.utils.JsonParser
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LocalNewsProvider @Inject constructor(
    private val jsonParser: JsonParser
) {
    private var cachedArticles: ArrayList<Article> = ArrayList()

    fun getArticles(): List<Article> {
        if (cachedArticles.isEmpty()) {
            val response = jsonParser.parseNews("news_data.json")
            response.articles?.let {
                cachedArticles.addAll(it)
            }
        }
        return cachedArticles
    }
}
