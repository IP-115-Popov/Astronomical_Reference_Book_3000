package ru.sergey.astronomicalreferencebook3000.presentation.di
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.components.SingletonComponent
import ru.sergey.damain.UseCase.LikesUseCase
import ru.sergey.damain.UseCase.UploadNewsUseCase
import ru.sergey.damain.repository.NewsRepository
import javax.inject.Singleton

@Module
@InstallIn(ViewModelComponent::class)
class DomainModule {
    @Provides
    fun provideUploadNewsUseCase(newsRepository : NewsRepository ) : UploadNewsUseCase {
        return UploadNewsUseCase(newsRepository = newsRepository)
    }
    @Provides
    fun provideLikesUseCase(newsRepository : NewsRepository ) : LikesUseCase {
        return LikesUseCase(newsRepository = newsRepository)
    }
}