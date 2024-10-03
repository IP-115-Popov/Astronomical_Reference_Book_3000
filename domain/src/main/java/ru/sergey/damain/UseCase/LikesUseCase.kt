package ru.sergey.damain.UseCase

import ru.sergey.damain.models.News
import ru.sergey.damain.repository.NewsRepository

class LikesUseCase(private val newsRepository: NewsRepository) {
    fun exectute(newsId : Int)
    {
        newsRepository.getLikesNews(newsId)
    }
}