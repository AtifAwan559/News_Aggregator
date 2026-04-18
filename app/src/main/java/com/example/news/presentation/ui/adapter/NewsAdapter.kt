package com.example.news.presentation.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.news.R
import com.example.news.data.model.Article
import com.example.news.databinding.ItemArticleBinding

class NewsAdapter(
    private val onBookmarkClick: (Article) -> Unit,
    private val isBookmarked: (String) -> Boolean
) : ListAdapter<Article, NewsAdapter.ArticleViewHolder>(ArticleDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleViewHolder {
        val binding = ItemArticleBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ArticleViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class ArticleViewHolder(private val binding: ItemArticleBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(article: Article) {
            binding.apply {
                tvTitle.text = article.title
                tvDescription.text = article.description
                tvCategory.text = article.category.uppercase()
                tvPublishedAt.text = article.publishedAt.substringBefore("T")
                
                ivArticleImage.load(article.imageUrl) {
                    crossfade(true)
                    placeholder(android.R.drawable.ic_menu_gallery)
                    error(android.R.drawable.ic_menu_report_image)
                }

                val bookmarkRes = if (isBookmarked(article.id)) {
                    R.drawable.ic_bookmark_filled
                } else {
                    R.drawable.ic_bookmark_border
                }
                ivBookmark.setImageResource(bookmarkRes)

                ivBookmark.setOnClickListener {
                    onBookmarkClick(article)
                }
            }
        }
    }

    class ArticleDiffCallback : DiffUtil.ItemCallback<Article>() {
        override fun areItemsTheSame(oldItem: Article, newItem: Article): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Article, newItem: Article): Boolean {
            return oldItem == newItem
        }
    }
}
