package com.example.newsapp.di;

import com.example.newsapp.data.repository.NewsRepositoryImpl;
import com.example.newsapp.domain.repository.NewsRepository;
import com.google.gson.Gson;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;
import javax.inject.Singleton;

@dagger.Module()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\'\u0018\u0000 \u00072\u00020\u0001:\u0001\u0007B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\'\u00a8\u0006\b"}, d2 = {"Lcom/example/newsapp/di/AppModule;", "", "()V", "bindNewsRepository", "Lcom/example/newsapp/domain/repository/NewsRepository;", "newsRepositoryImpl", "Lcom/example/newsapp/data/repository/NewsRepositoryImpl;", "Companion", "app_debug"})
@dagger.hilt.InstallIn(value = {dagger.hilt.components.SingletonComponent.class})
public abstract class AppModule {
    @org.jetbrains.annotations.NotNull()
    public static final com.example.newsapp.di.AppModule.Companion Companion = null;
    
    public AppModule() {
        super();
    }
    
    @dagger.Binds()
    @javax.inject.Singleton()
    @org.jetbrains.annotations.NotNull()
    public abstract com.example.newsapp.domain.repository.NewsRepository bindNewsRepository(@org.jetbrains.annotations.NotNull()
    com.example.newsapp.data.repository.NewsRepositoryImpl newsRepositoryImpl);
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007\u00a8\u0006\u0005"}, d2 = {"Lcom/example/newsapp/di/AppModule$Companion;", "", "()V", "provideGson", "Lcom/google/gson/Gson;", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @dagger.Provides()
        @javax.inject.Singleton()
        @org.jetbrains.annotations.NotNull()
        public final com.google.gson.Gson provideGson() {
            return null;
        }
    }
}