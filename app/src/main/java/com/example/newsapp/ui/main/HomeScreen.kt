package com.example.newsapp.ui.main

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.newsapp.R
import com.example.newsapp.ui.components.HorizontalArticleList
import com.example.newsapp.ui.components.NewsCarousel
import com.example.newsapp.ui.components.SectionHeader

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    navController: NavController,
    viewModel: MainViewModel = hiltViewModel()
) {
    val headlines by viewModel.headlines.collectAsState()
    val trending by viewModel.trending.collectAsState()
    val worldNews by viewModel.worldNews.collectAsState()
    val technology by viewModel.technology.collectAsState()

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { 
                    Text(
                        stringResource(id = R.string.app_name),
                        style = MaterialTheme.typography.headlineMedium,
                        color = MaterialTheme.colorScheme.primary
                    ) 
                },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.background
                )
            )
        }
    ) { padding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
        ) {
            item {
                if (headlines.isNotEmpty()) {
                    NewsCarousel(
                        articles = headlines,
                        onArticleClick = { navController.navigate("detail/${it.id}") }
                    )
                }
            }

            item {
                SectionHeader(title = "Trending")
                HorizontalArticleList(
                    articles = trending,
                    onArticleClick = { navController.navigate("detail/${it.id}") }
                )
            }

            item {
                SectionHeader(title = "World News")
                HorizontalArticleList(
                    articles = worldNews,
                    onArticleClick = { navController.navigate("detail/${it.id}") }
                )
            }

            item {
                SectionHeader(title = "Technology")
                HorizontalArticleList(
                    articles = technology,
                    onArticleClick = { navController.navigate("detail/${it.id}") }
                )
            }
            
            item { Spacer(modifier = Modifier.height(16.dp)) }
        }
    }
}
