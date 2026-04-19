package com.example.newsapp.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.newsapp.ui.components.VerticalArticleItem
import com.example.newsapp.ui.main.MainViewModel

// ✅ Strong typing > stringly-typed bugs
enum class Category(val label: String) {
    ALL("All"),
    WORLD("World"),
    TECHNOLOGY("Technology"),
    BUSINESS("Business"),
    OPINION("Opinion")
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CategoryScreen(
    navController: NavController,
    viewModel: MainViewModel = hiltViewModel()
) {
    // 🔄 State sources
    val headlines by viewModel.headlines.collectAsState()
    val worldNews by viewModel.worldNews.collectAsState()
    val technology by viewModel.technology.collectAsState()
    val opinion by viewModel.opinion.collectAsState()

    var selectedCategory by remember { mutableStateOf(Category.ALL) }

    // ✅ Derived filtering (single source of truth)
    val articles = remember(
        selectedCategory,
        headlines,
        worldNews,
        technology,
        opinion
    ) {
        when (selectedCategory) {
            Category.ALL -> headlines
            Category.WORLD -> worldNews
            Category.TECHNOLOGY -> technology
            Category.OPINION -> opinion
            Category.BUSINESS -> headlines.filter { it.category == "Business" }
        }
    }

    Column(modifier = Modifier.fillMaxSize()) {

        // 🔥 Tabs (stable + index safe)
        ScrollableTabRow(
            selectedTabIndex = selectedCategory.ordinal,
            edgePadding = 16.dp,
            containerColor = MaterialTheme.colorScheme.background,
            contentColor = MaterialTheme.colorScheme.primary,
            divider = {}
        ) {
            Category.values().forEach { category ->
                Tab(
                    selected = selectedCategory == category,
                    onClick = { selectedCategory = category },
                    text = { Text(category.label) }
                )
            }
        }

        // 🔄 Loading / Empty / Content handling
        when {
            // ⚠️ Initial loading (all empty)
            headlines.isEmpty() &&
                    worldNews.isEmpty() &&
                    technology.isEmpty() &&
                    opinion.isEmpty() -> {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    CircularProgressIndicator()
                }
            }

            // ⚠️ Empty category
            articles.isEmpty() -> {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "No articles available",
                        style = MaterialTheme.typography.bodyLarge
                    )
                }
            }

            // ✅ Main list
            else -> {
                LazyColumn(
                    modifier = Modifier.fillMaxSize(),
                    contentPadding = PaddingValues(bottom = 16.dp)
                ) {
                    items(
                        items = articles,
                        key = { it.id } // 🔥 critical for stable recomposition
                    ) { article ->
                        VerticalArticleItem(
                            article = article,
                            onClick = {
                                navController.navigate("detail/${article.id}")
                            },
                            onBookmarkToggle = {
                                viewModel.toggleBookmark(article.id)
                            }
                        )

                        HorizontalDivider(
                            modifier = Modifier.padding(horizontal = 16.dp),
                            thickness = 0.5.dp
                        )
                    }
                }
            }
        }
    }
}
