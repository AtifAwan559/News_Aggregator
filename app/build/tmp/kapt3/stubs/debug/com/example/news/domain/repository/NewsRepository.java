package com.example.news.domain.repository;

import com.example.news.data.model.Article;
import kotlinx.coroutines.flow.Flow;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0014\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0003H&J\u0014\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0003H&J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH&J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0005H&\u00a8\u0006\u000e"}, d2 = {"Lcom/example/news/domain/repository/NewsRepository;", "", "getArticles", "Lkotlinx/coroutines/flow/Flow;", "", "Lcom/example/news/data/model/Article;", "getBookmarks", "isBookmarked", "", "articleId", "", "toggleBookmark", "", "article", "app_debug"})
public abstract interface NewsRepository {
    
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.example.news.data.model.Article>> getArticles();
    
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.example.news.data.model.Article>> getBookmarks();
    
    public abstract void toggleBookmark(@org.jetbrains.annotations.NotNull()
    com.example.news.data.model.Article article);
    
    public abstract boolean isBookmarked(@org.jetbrains.annotations.NotNull()
    java.lang.String articleId);
}