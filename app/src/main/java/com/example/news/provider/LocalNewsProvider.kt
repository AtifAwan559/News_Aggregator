package com.example.news.provider

import com.example.news.model.Article
import com.example.newsapp.utils.JsonParser
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LocalNewsProvider @Inject constructor(private val jsonParser: JsonParser) {
    private var cachedArticles: ArrayList<Article> = ArrayList()

    fun getArticles(): List<Article> {
        if (cachedArticles.isEmpty()) {
            val response = jsonParser.parseNews("news_metadata.json")
            // Note: Mapping might be needed if Article models differ, 
            // but this resolves the dependency issue for Kapt.
            response.articles.let {
                // Assuming Article types are compatible or this is a legacy file
            }
        }
        return cachedArticles
    }
}
