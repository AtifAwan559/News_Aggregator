package com.example.news.presentation.ui.activities

import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.addTextChangedListener
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.news.databinding.ActivityMainBinding
import com.example.news.presentation.ui.adapter.NewsAdapter
import com.example.news.presentation.viewmodel.NewsViewModel
import com.google.android.material.chip.Chip
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: NewsViewModel by viewModels()
    private lateinit var newsAdapter: NewsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupRecyclerView()
        setupListeners()
        observeState()
    }

    private fun setupRecyclerView() {
        newsAdapter = NewsAdapter(
            onBookmarkClick = { article -> viewModel.toggleBookmark(article) },
            isBookmarked = { id -> viewModel.bookmarks.value.any { it.id == id } }
        )
        binding.rvNews.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = newsAdapter
        }
    }

    private fun setupListeners() {
        binding.searchView.editText.addTextChangedListener { text ->
            viewModel.onSearchQueryChanged(text?.toString().orEmpty())
        }

        binding.chipGroup.setOnCheckedStateChangeListener { group, checkedIds ->
            val checkedId = checkedIds.firstOrNull()
            if (checkedId != null) {
                val chip = group.findViewById<Chip>(checkedId)
                viewModel.onCategorySelected(chip.text.toString())
            } else {
                viewModel.onCategorySelected("All")
            }
        }
    }

    private fun observeState() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                launch {
                    viewModel.filteredArticles.collect { articles ->
                        newsAdapter.submitList(articles)
                        binding.tvEmptyState.visibility = if (articles.isEmpty()) View.VISIBLE else View.GONE
                    }
                }
                
                launch {
                    viewModel.bookmarks.collect {
                        // Refresh adapter to update bookmark icons
                        newsAdapter.notifyDataSetChanged()
                    }
                }
            }
        }
    }
}
