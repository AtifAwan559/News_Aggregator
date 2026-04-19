package com.example.news.data.repository;

import com.example.news.data.local.LocalNewsProvider;
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
  private final Provider<LocalNewsProvider> localNewsProvider;

  public NewsRepositoryImpl_Factory(Provider<LocalNewsProvider> localNewsProvider) {
    this.localNewsProvider = localNewsProvider;
  }

  @Override
  public NewsRepositoryImpl get() {
    return newInstance(localNewsProvider.get());
  }

  public static NewsRepositoryImpl_Factory create(
      javax.inject.Provider<LocalNewsProvider> localNewsProvider) {
    return new NewsRepositoryImpl_Factory(Providers.asDaggerProvider(localNewsProvider));
  }

  public static NewsRepositoryImpl_Factory create(Provider<LocalNewsProvider> localNewsProvider) {
    return new NewsRepositoryImpl_Factory(localNewsProvider);
  }

  public static NewsRepositoryImpl newInstance(LocalNewsProvider localNewsProvider) {
    return new NewsRepositoryImpl(localNewsProvider);
  }
}
