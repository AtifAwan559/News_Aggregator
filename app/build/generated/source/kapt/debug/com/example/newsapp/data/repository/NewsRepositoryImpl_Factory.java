package com.example.newsapp.data.repository;

import com.example.newsapp.data.source.NewsDataSource;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Provider;
import dagger.internal.Providers;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;

@ScopeMetadata("javax.inject.Singleton")
@QualifierMetadata
@DaggerGenerated
@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes",
    "KotlinInternal",
    "KotlinInternalInJava",
    "cast",
    "deprecation",
    "nullness:initialization.field.uninitialized"
})
public final class NewsRepositoryImpl_Factory implements Factory<NewsRepositoryImpl> {
  private final Provider<NewsDataSource> dataSourceProvider;

  public NewsRepositoryImpl_Factory(Provider<NewsDataSource> dataSourceProvider) {
    this.dataSourceProvider = dataSourceProvider;
  }

  @Override
  public NewsRepositoryImpl get() {
    return newInstance(dataSourceProvider.get());
  }

  public static NewsRepositoryImpl_Factory create(
      javax.inject.Provider<NewsDataSource> dataSourceProvider) {
    return new NewsRepositoryImpl_Factory(Providers.asDaggerProvider(dataSourceProvider));
  }

  public static NewsRepositoryImpl_Factory create(Provider<NewsDataSource> dataSourceProvider) {
    return new NewsRepositoryImpl_Factory(dataSourceProvider);
  }

  public static NewsRepositoryImpl newInstance(NewsDataSource dataSource) {
    return new NewsRepositoryImpl(dataSource);
  }
}
