package ru.sergey.data.repository

import ru.sergey.damain.models.News
import ru.sergey.damain.repository.NewsRepository

class NewsRepositoryImp : NewsRepository {
    val storage  = listOf(
        News(1,"aboba1",1),
        News(2,"aboba2",1),
        News(3,"aboba3",1),
        News(4,"aboba4",1),
        News(5,"aboba5",1),
        News(6,"aboba6",1),
        News(7,"aboba7",1),
        News(8,"aboba8",1),
        News(9,"aboba9",1),
        News(10,"aboba10",1),
    )
    override fun loadNews(): List<News> {
        return storage
    }

    override fun getLikesNews(newsId: Int) {
        storage.forEach { it: News ->
            if (it.id == newsId)
            {
                it.likes++
            }
        }
    }

}