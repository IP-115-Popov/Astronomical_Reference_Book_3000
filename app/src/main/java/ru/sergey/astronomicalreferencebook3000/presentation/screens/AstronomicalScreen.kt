package ru.sergey.astronomicalreferencebook3000.presentation.screens

import android.content.Context
import android.opengl.GLSurfaceView
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.viewinterop.AndroidView
import ru.sergey.astronomicalreferencebook3000.gl.MyGLRenderer
import ru.sergey.astronomicalreferencebook3000.gl.MyGLSurfaceView


@Composable
fun AstronomicalScreen() {
    AndroidView(
        factory = { context ->
            val glSurfaceView = GLSurfaceView(context)
            glSurfaceView.setEGLContextClientVersion(2)
            glSurfaceView.setRenderer(MyGLRenderer()) // Устанавливаем рендерер
            glSurfaceView
        }
    )
}