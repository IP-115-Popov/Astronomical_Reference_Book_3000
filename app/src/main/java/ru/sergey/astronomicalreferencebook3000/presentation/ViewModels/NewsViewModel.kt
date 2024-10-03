package ru.sergey.astronomicalreferencebook3000.presentation.ViewModels

import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.lifecycle.ViewModel
import ru.sergey.damain.UseCase.LikesUseCase
import ru.sergey.damain.UseCase.UploadNewsUseCase
import ru.sergey.damain.models.News
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NewsViewModel @Inject constructor(
    val uploadNewsUseCase: UploadNewsUseCase,
    val likesUseCase : LikesUseCase
) : ViewModel() {

    var newsList  = listOf<News>()
    var showNewsList =  mutableStateListOf<News>()

    var uniqueRandomNumbers = List<Int>(4){1}



    init {
        uploadShowNews()
        startPeriodicNewsUpload()
        //viewModelScope.launch(Dispatchers.IO) {
         //   while(true) {
        //        uploadShowNews()
        //        delay(5000)
        //    }
        //}
    }
    private fun startPeriodicNewsUpload() {
        viewModelScope.launch(Dispatchers.Main) {
            while (isActive) { // Проверка активного состояния ViewModel
                uploadShowNews()
                delay(5000) // Задержка в 5 секунд
            }
        }
    }

    fun uploadShowNews()
    {
        newsList = uploadNewsUseCase.exectute()

        val numbers = (0..newsList.size-1).toList()
        uniqueRandomNumbers = numbers.shuffled().take(4)
        showNewsList.clear()
        showNewsList.addAll(uniqueRandomNumbers.map { newsList[it] })

    }

    fun likes(newsId: Int)
    {

        likesUseCase.exectute(newsId)
        newsList = uploadNewsUseCase.exectute()
        showNewsList.apply {
            clear()
            addAll(uniqueRandomNumbers.map { newsList[it] })
        }
    }

}