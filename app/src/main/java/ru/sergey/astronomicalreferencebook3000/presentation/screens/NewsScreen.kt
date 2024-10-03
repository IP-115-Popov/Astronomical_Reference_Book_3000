package ru.sergey.astronomicalreferencebook3000.presentation.screens

import android.annotation.SuppressLint
import android.content.Context
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


import ru.sergey.astronomicalreferencebook3000.R
import ru.sergey.astronomicalreferencebook3000.presentation.ViewModels.NewsViewModel
import ru.sergey.astronomicalreferencebook3000.presentation.theme.Pink80
import ru.sergey.astronomicalreferencebook3000.presentation.theme.Purple80
import ru.sergey.astronomicalreferencebook3000.presentation.theme.PurpleGrey120
import ru.sergey.astronomicalreferencebook3000.presentation.theme.PurpleGrey40
import ru.sergey.damain.UseCase.LikesUseCase
import ru.sergey.damain.UseCase.UploadNewsUseCase
import ru.sergey.damain.models.News
import ru.sergey.data.repository.NewsRepositoryImp
val newsRepository = NewsRepositoryImp()

//val vm : NewsViewModel by inject<NewsViewModel>()
//@Preview(showBackground = true, showSystemUi = true)
@Composable
fun NewsScreen(vm : NewsViewModel)
{
    Column(
        modifier = Modifier.fillMaxSize()) {
        var lol = 1

        Row(modifier = Modifier
            .background(PurpleGrey40)
            .fillMaxWidth()
            .fillMaxHeight(0.5f)){
            NewsCard(vm.showNewsList[0], modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth(0.5f),
                vm)
            NewsCard(vm.showNewsList[1], modifier = Modifier.fillMaxSize(), vm)
        }
        Row(modifier = Modifier
            .background(PurpleGrey40)
            .fillMaxWidth()
            .fillMaxHeight()) {
            NewsCard(vm.showNewsList[2], modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth(0.5f),
                vm)
            NewsCard(vm.showNewsList[3], modifier = Modifier.fillMaxSize(),vm)
        }
    }
}
@SuppressLint("CoroutineCreationDuringComposition")
@Composable
fun NewsCard(news: News , modifier: Modifier = Modifier, vm: NewsViewModel)
{
    val defaultModifier = Modifier
        .padding(10.dp)
        .shadow(3.dp, RoundedCornerShape(10.dp))
        .clip(RoundedCornerShape(10.dp))

    Surface(defaultModifier.then(modifier)) {
        Column(modifier = Modifier.background(PurpleGrey120)) {
            Text(text = news.content, modifier = Modifier
                .padding(10.dp)
                .fillMaxWidth()
                .shadow(3.dp, RoundedCornerShape(5.dp))
                .clip(RoundedCornerShape(5.dp))
                .background(Pink80)
                .padding(start = 20.dp, end = 10.dp, top = 5.dp, bottom = 5.dp))
            Spacer(modifier = Modifier.weight(1f))
            Text(
                text =  stringResource(R.string.likes, news.likes)
                ,modifier = Modifier
                    .padding(10.dp)
                    .align(alignment = Alignment.End)
                    .shadow(3.dp, RoundedCornerShape(5.dp))
                    .clip(RoundedCornerShape(5.dp))
                    .background(Purple80)
                    .padding(5.dp)
                    .clickable {
                        vm.likes(news.id)
                    }
            )
        }

    }
}