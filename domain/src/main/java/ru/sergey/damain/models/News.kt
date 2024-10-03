package ru.sergey.damain.models

data class News(
    val id: Int,
    val content: String,
    var likes: Int
)