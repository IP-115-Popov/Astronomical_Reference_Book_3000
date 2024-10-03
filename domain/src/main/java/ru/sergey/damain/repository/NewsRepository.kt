package ru.sergey.damain.repository

import ru.sergey.damain.models.News

interface NewsRepository {
    fun loadNews(): List<News>
    fun getLikesNews(newsId : Int)
}