package com.example.newsapp.ui.news

import android.os.Bundle
import android.os.Parcelable
import androidx.navigation.NavDirections
import com.example.newsapp.R
import com.example.newsapp.domain.model.Article
import java.io.Serializable
import java.lang.UnsupportedOperationException
import kotlin.Int
import kotlin.Suppress

public class NewsFeedFragmentDirections private constructor() {
  private data class ActionNewsFeedFragmentToNewsDetailFragment(
    public val article: Article,
  ) : NavDirections {
    public override val actionId: Int = R.id.action_newsFeedFragment_to_newsDetailFragment

    public override val arguments: Bundle
      @Suppress("CAST_NEVER_SUCCEEDS")
      get() {
        val result = Bundle()
        if (Parcelable::class.java.isAssignableFrom(Article::class.java)) {
          result.putParcelable("article", this.article as Parcelable)
        } else if (Serializable::class.java.isAssignableFrom(Article::class.java)) {
          result.putSerializable("article", this.article as Serializable)
        } else {
          throw UnsupportedOperationException(Article::class.java.name +
              " must implement Parcelable or Serializable or must be an Enum.")
        }
        return result
      }
  }

  public companion object {
    public fun actionNewsFeedFragmentToNewsDetailFragment(article: Article): NavDirections =
        ActionNewsFeedFragmentToNewsDetailFragment(article)
  }
}
