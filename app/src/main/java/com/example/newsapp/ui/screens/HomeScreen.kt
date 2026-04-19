package com.example.newsapp.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.newsapp.R
import com.example.newsapp.ui.components.*
import com.example.newsapp.ui.main.MainViewModel

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
    val opinion by viewModel.opinion.collectAsState()

    val scrollBehavior = TopAppBarDefaults.exitUntilCollapsedScrollBehavior()

    Scaffold(
        modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            CenterAlignedTopAppBar(
                title = { 
                    Text(
                        stringResource(id = R.string.app_name),
                        style = MaterialTheme.typography.headlineMedium,
                        color = MaterialTheme.colorScheme.primary
                    ) 
                },
                scrollBehavior = scrollBehavior,
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.background
                )
            )
        }
    ) { padding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding),
            contentPadding = PaddingValues(bottom = 24.dp)
        ) {
            // HERO SECTION
            item {
                if (headlines.isNotEmpty()) {
                    HeroArticleCard(
                        article = headlines.first(),
                        onClick = { navController.navigate("detail/${headlines.first().id}") }
                    )
                }
            }

            // TRENDING
            if (trending.isNotEmpty()) {
                item {
                    SectionHeader(title = "Trending")
                    HorizontalArticleList(
                        articles = trending,
                        onArticleClick = { navController.navigate("detail/${it.id}") }
                    )
                }
            }

            // WORLD NEWS
            if (worldNews.isNotEmpty()) {
                item {
                    SectionHeader(title = "World News")
                }
                items(worldNews.take(5)) { article ->
                    FeaturedArticleCard(
                        article = article,
                        onClick = { navController.navigate("detail/${article.id}") }
                    )
                }
            }

            // OPINION & EDITORIAL
            if (opinion.isNotEmpty()) {
                item {
                    SectionHeader(title = "Opinion & Editorial")
                    OpinionArticleList(
                        articles = opinion,
                        onArticleClick = { navController.navigate("detail/${it.id}") }
                    )
                }
            }

            // TECHNOLOGY
            if (technology.isNotEmpty()) {
                item {
                    SectionHeader(title = "Technology")
                }
                items(technology.chunked(2)) { row ->
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 12.dp),
                        horizontalArrangement = Arrangement.spacedBy(12.dp)
                    ) {
                        row.forEach { article ->
                            Box(modifier = Modifier.weight(1f)) {
                                GridArticleCard(
                                    article = article,
                                    onClick = { navController.navigate("detail/${article.id}") }
                                )
                            }
                        }
                        if (row.size == 1) Spacer(modifier = Modifier.weight(1f))
                    }
                    Spacer(modifier = Modifier.height(12.dp))
                }
            }
        }
    }
}
