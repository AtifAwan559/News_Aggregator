package com.example.newsapp.utils

import android.content.Context
import android.content.res.AssetManager
import com.example.newsapp.data.model.Article
import com.example.newsapp.data.model.NewsResponse
import com.google.gson.Gson
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations
import java.io.ByteArrayInputStream

class JsonParserTest {

    @Mock
    private lateinit var context: Context

    @Mock
    private lateinit var assetManager: AssetManager

    private lateinit var jsonParser: JsonParser
    private val gson = Gson()

    @Before
    fun setUp() {
        MockitoAnnotations.openMocks(this)
        `when`(context.assets).thenReturn(assetManager)
        jsonParser = JsonParser(context, gson)
    }

    @Test
    fun `parseNews with valid json returns articles`() {
        val json = """
            {
              "articles": [
                {
                  "id": "1",
                  "title": "Test Title",
                  "description": "Test Desc",
                  "category": "Tech",
                  "imageUrl": "url",
                  "isBookmarked": false
                }
              ]
            }
        """.trimIndent()
        
        val fileName = "test.json"
        `when`(assetManager.open(fileName)).thenReturn(ByteArrayInputStream(json.toByteArray()))

        val response = jsonParser.parseNews(fileName)

        assertEquals(1, response.articles?.size)
        assertEquals("Test Title", response.articles?.get(0)?.title)
    }

    @Test
    fun `parseNews with invalid json returns empty articles`() {
        val fileName = "invalid.json"
        `when`(assetManager.open(fileName)).thenThrow(RuntimeException("File not found"))

        val response = jsonParser.parseNews(fileName)

        assertEquals(0, response.articles?.size)
    }
}
