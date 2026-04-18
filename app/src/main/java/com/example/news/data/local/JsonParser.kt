package com.example.news.data.local

import android.content.Context
import com.example.news.data.model.NewsResponse
import com.google.gson.Gson
import dagger.hilt.android.qualifiers.ApplicationContext
import java.io.IOException
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class JsonParser @Inject constructor(
    @ApplicationContext private val context: Context,
    private val gson: Gson
) {
    fun parseNews(fileName: String): NewsResponse? {
        return try {
            val jsonString = context.assets.open(fileName).bufferedReader().use { it.readText() }
            gson.fromJson(jsonString, NewsResponse::class.java)
        } catch (e: IOException) {
            e.printStackTrace()
            null
        } catch (e: Exception) {
            e.printStackTrace()
            null
        }
    }
}
