package com.example.newsapp.utils;

import android.content.Context;
import com.google.gson.Gson;
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
public final class JsonParser_Factory implements Factory<JsonParser> {
  private final Provider<Context> contextProvider;

  private final Provider<Gson> gsonProvider;

  public JsonParser_Factory(Provider<Context> contextProvider, Provider<Gson> gsonProvider) {
    this.contextProvider = contextProvider;
    this.gsonProvider = gsonProvider;
  }

  @Override
  public JsonParser get() {
    return newInstance(contextProvider.get(), gsonProvider.get());
  }

  public static JsonParser_Factory create(javax.inject.Provider<Context> contextProvider,
      javax.inject.Provider<Gson> gsonProvider) {
    return new JsonParser_Factory(Providers.asDaggerProvider(contextProvider), Providers.asDaggerProvider(gsonProvider));
  }

  public static JsonParser_Factory create(Provider<Context> contextProvider,
      Provider<Gson> gsonProvider) {
    return new JsonParser_Factory(contextProvider, gsonProvider);
  }

  public static JsonParser newInstance(Context context, Gson gson) {
    return new JsonParser(context, gson);
  }
}
