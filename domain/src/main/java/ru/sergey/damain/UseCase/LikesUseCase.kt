package ru.sergey.damain.UseCase

import ru.sergey.damain.models.News
import ru.sergey.damain.repository.NewsRepository

class LikesUseCase(private val newsRepository: NewsRepository) {
    fun exectute(news : News)
    {
        newsRepository.getLikesNews(news)
    }
}