package ru.sergey.damain.UseCase

import ru.sergey.damain.models.News
import ru.sergey.damain.repository.NewsRepository

class UploadNewsUseCase(private val newsRepository: NewsRepository) {
    fun exectute(): List<News> {
        return newsRepository.loadNews()
    }
}