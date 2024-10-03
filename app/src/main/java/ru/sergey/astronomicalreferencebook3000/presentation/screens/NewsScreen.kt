package ru.sergey.astronomicalreferencebook3000.presentation.screens

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import ru.sergey.astronomicalreferencebook3000.presentation.ViewModels.NewsViewModel

@Composable
fun newsScreen(vm: NewsViewModel = viewModel())
{
    Text(text = vm.helloText)
}