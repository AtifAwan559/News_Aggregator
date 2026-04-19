package com.example.news.data.repository;

import com.example.news.data.local.LocalNewsProvider;
import com.example.news.data.model.Article;
import com.example.news.domain.repository.NewsRepository;
import kotlinx.coroutines.flow.Flow;
import javax.inject.Inject;
import javax.inject.Singleton;

@javax.inject.Singleton()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0014\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\nH\u0016J\u0014\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\nH\u0016J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\bH\u0016R\u001a\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0014"}, d2 = {"Lcom/example/news/data/repository/NewsRepositoryImpl;", "Lcom/example/news/domain/repository/NewsRepository;", "localNewsProvider", "Lcom/example/news/data/local/LocalNewsProvider;", "(Lcom/example/news/data/local/LocalNewsProvider;)V", "_bookmarks", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "Lcom/example/news/data/model/Article;", "bookmarks", "Lkotlinx/coroutines/flow/Flow;", "getArticles", "getBookmarks", "isBookmarked", "", "articleId", "", "toggleBookmark", "", "article", "app_debug"})
public final class NewsRepositoryImpl implements com.example.news.domain.repository.NewsRepository {
    @org.jetbrains.annotations.NotNull()
    private final com.example.news.data.local.LocalNewsProvider localNewsProvider = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<java.util.List<com.example.news.data.model.Article>> _bookmarks = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.Flow<java.util.List<com.example.news.data.model.Article>> bookmarks = null;
    
    @javax.inject.Inject()
    public NewsRepositoryImpl(@org.jetbrains.annotations.NotNull()
    com.example.news.data.local.LocalNewsProvider localNewsProvider) {
        super();
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public kotlinx.coroutines.flow.Flow<java.util.List<com.example.news.data.model.Article>> getArticles() {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public kotlinx.coroutines.flow.Flow<java.util.List<com.example.news.data.model.Article>> getBookmarks() {
        return null;
    }
    
    @java.lang.Override()
    public void toggleBookmark(@org.jetbrains.annotations.NotNull()
    com.example.news.data.model.Article article) {
    }
    
    @java.lang.Override()
    public boolean isBookmarked(@org.jetbrains.annotations.NotNull()
    java.lang.String articleId) {
        return false;
    }
}