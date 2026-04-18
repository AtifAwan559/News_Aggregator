package com.example.news.util

import android.content.Context
import com.example.news.model.NewsResponse
import com.google.gson.Gson
import java.io.IOException

class JsonParser(private val context: Context) {
    fun getNewsFromJson(fileName: String): NewsResponse? {
        val jsonString: String
        try {
            jsonString = context.assets.open(fileName).bufferedReader().use { it.readText() }
        } catch (ioException: IOException) {
            ioException.printStackTrace()
            return null
        }
        return Gson().fromJson(jsonString, NewsResponse::class.java)
    }
}
