package ui.anwesome.com.trianglemover

import android.content.Context
import android.view.*
import android.graphics.*

/**
 * Created by anweshmishra on 26/12/17.
 */
class TriangleMoverView(ctx:Context):View(ctx) {
    val paint = Paint(Paint.ANTI_ALIAS_FLAG)
    override fun onDraw(canvas:Canvas) {

    }
    override fun onTouchEvent(event:MotionEvent):Boolean {
        when(event.action) {
            MotionEvent.ACTION_DOWN -> {

            }
        }
        return true
    }
}