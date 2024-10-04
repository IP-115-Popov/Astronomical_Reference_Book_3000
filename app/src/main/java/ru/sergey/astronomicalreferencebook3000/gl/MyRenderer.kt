package ru.sergey.astronomicalreferencebook3000.gl
import android.opengl.GLSurfaceView
import java.nio.ByteBuffer
import java.nio.ByteOrder
import java.nio.FloatBuffer
import javax.microedition.khronos.egl.EGLConfig
import javax.microedition.khronos.opengles.GL10

class MyRenderer : GLSurfaceView.Renderer {
    var p : Float = 0f
    var a: FloatArray = floatArrayOf(
        -1f, 1f, 0f,
        -1f, -1f, 0f,
        1f, -1f, 0f,
        1f, 1f, 0f
    )

    var f : FloatBuffer
    init {
        f = floatArrayToFloatBuffer(a)
    }
    fun floatArrayToFloatBuffer(a: FloatArray) : FloatBuffer
    {
        var fRez: FloatBuffer
        var b: ByteBuffer = ByteBuffer.allocateDirect(a.size * 4)
        b.order(ByteOrder.nativeOrder())
        fRez = b.asFloatBuffer()
        fRez.put(a)
        fRez.position(0)
        return fRez
    }

    //при создании поверхности
    override fun onSurfaceCreated(gl: GL10, config: EGLConfig) {}
    //при изменении поверхности например повороте
    override fun onSurfaceChanged(gl: GL10, width: Int, height: Int) {}


    //при кадре
    override fun onDrawFrame(gl: GL10) {
        //цвет фона
        gl.glClearColor(1f, 1f, 0f, 1f)
        //очищаем буфер цвета
        gl.glClear(GL10.GL_COLOR_BUFFER_BIT)
        //мастрицу проекции в единичное состояние
        gl.glLoadIdentity()
        //отодвегаем назад
        gl.glTranslatef(0f, 0f, -1f)
        //мосштабируем
        gl.glScalef(0.5f, 0.5f, 0.5f)
        //покрасить квадрат
        gl.glColor4f(0f, 1f, 1f, 1f)

        gl.glRotatef(p,0f,0f,1f)
        p = if (p > 360) 0f else p + 0.1f

        ////будим отрисовывать при помощи массива вершин бесполезная функция
        gl.glEnableClientState(GL10.GL_VERTEX_ARRAY)
        drawRectangle(gl, f)
        ////выключаем бесполезный режим отрисовки
        gl.glDisableClientState(GL10.GL_VERTEX_ARRAY)
    }
    private fun drawRectangle(gl: GL10, f : FloatBuffer) {
        //указатель на масив вуршин для отрисовки
        gl.glVertexPointer(3, GL10.GL_FLOAT, 0, f)
        //функция выведения массива вершин
        gl.glDrawArrays(GL10.GL_TRIANGLE_FAN, 0, 4)
    }
}