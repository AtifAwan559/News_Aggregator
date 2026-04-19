package com.example.newsapp.domain.usecase;

import com.example.newsapp.domain.repository.NewsRepository;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Provider;
import dagger.internal.Providers;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;

@ScopeMetadata
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
public final class GetHeadlinesUseCase_Factory implements Factory<GetHeadlinesUseCase> {
  private final Provider<NewsRepository> repositoryProvider;

  public GetHeadlinesUseCase_Factory(Provider<NewsRepository> repositoryProvider) {
    this.repositoryProvider = repositoryProvider;
  }

  @Override
  public GetHeadlinesUseCase get() {
    return newInstance(repositoryProvider.get());
  }

  public static GetHeadlinesUseCase_Factory create(
      javax.inject.Provider<NewsRepository> repositoryProvider) {
    return new GetHeadlinesUseCase_Factory(Providers.asDaggerProvider(repositoryProvider));
  }

  public static GetHeadlinesUseCase_Factory create(Provider<NewsRepository> repositoryProvider) {
    return new GetHeadlinesUseCase_Factory(repositoryProvider);
  }

  public static GetHeadlinesUseCase newInstance(NewsRepository repository) {
    return new GetHeadlinesUseCase(repository);
  }
}
