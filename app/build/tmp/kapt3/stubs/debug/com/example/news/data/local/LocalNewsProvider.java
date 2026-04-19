package com.example.news.data.local;

import com.example.news.data.model.Article;
import javax.inject.Inject;
import javax.inject.Singleton;

@javax.inject.Singleton()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\tR\u0016\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\n"}, d2 = {"Lcom/example/news/data/local/LocalNewsProvider;", "", "jsonParser", "Lcom/example/news/data/local/JsonParser;", "(Lcom/example/news/data/local/JsonParser;)V", "cachedArticles", "", "Lcom/example/news/data/model/Article;", "getArticles", "", "app_debug"})
public final class LocalNewsProvider {
    @org.jetbrains.annotations.NotNull()
    private final com.example.news.data.local.JsonParser jsonParser = null;
    @org.jetbrains.annotations.Nullable()
    private java.util.List<com.example.news.data.model.Article> cachedArticles;
    
    @javax.inject.Inject()
    public LocalNewsProvider(@org.jetbrains.annotations.NotNull()
    com.example.news.data.local.JsonParser jsonParser) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.example.news.data.model.Article> getArticles() {
        return null;
    }
}