package com.example.newsapp.data.local;

import com.example.newsapp.utils.JsonParser;
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
public final class LocalNewsProvider_Factory implements Factory<LocalNewsProvider> {
  private final Provider<JsonParser> jsonParserProvider;

  public LocalNewsProvider_Factory(Provider<JsonParser> jsonParserProvider) {
    this.jsonParserProvider = jsonParserProvider;
  }

  @Override
  public LocalNewsProvider get() {
    return newInstance(jsonParserProvider.get());
  }

  public static LocalNewsProvider_Factory create(
      javax.inject.Provider<JsonParser> jsonParserProvider) {
    return new LocalNewsProvider_Factory(Providers.asDaggerProvider(jsonParserProvider));
  }

  public static LocalNewsProvider_Factory create(Provider<JsonParser> jsonParserProvider) {
    return new LocalNewsProvider_Factory(jsonParserProvider);
  }

  public static LocalNewsProvider newInstance(JsonParser jsonParser) {
    return new LocalNewsProvider(jsonParser);
  }
}
