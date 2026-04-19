package com.example.newsapp.data.source;

import android.content.Context;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Provider;
import dagger.internal.Providers;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;

@ScopeMetadata("javax.inject.Singleton")
@QualifierMetadata("dagger.hilt.android.qualifiers.ApplicationContext")
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
public final class NewsDataSource_Factory implements Factory<NewsDataSource> {
  private final Provider<Context> contextProvider;

  public NewsDataSource_Factory(Provider<Context> contextProvider) {
    this.contextProvider = contextProvider;
  }

  @Override
  public NewsDataSource get() {
    return newInstance(contextProvider.get());
  }

  public static NewsDataSource_Factory create(javax.inject.Provider<Context> contextProvider) {
    return new NewsDataSource_Factory(Providers.asDaggerProvider(contextProvider));
  }

  public static NewsDataSource_Factory create(Provider<Context> contextProvider) {
    return new NewsDataSource_Factory(contextProvider);
  }

  public static NewsDataSource newInstance(Context context) {
    return new NewsDataSource(context);
  }
}
