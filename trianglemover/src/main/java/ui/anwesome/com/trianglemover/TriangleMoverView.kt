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
    data class TriangleMover(var x:Float,var y:Float,var size:Float,var deg:Float = 0f,var targetDeg:Float = 0f) {
        fun draw(canvas:Canvas,paint:Paint) {
            canvas.save()
            canvas.translate(x,y)
            canvas.rotate(deg)
            paint.color = Color.parseColor("#673AB7")
            val path = Path()
            path.moveTo(-size/2,size/2)
            path.lineTo(size/2,size/2)
            path.lineTo(0f,-size/2)
            canvas.drawPath(path,paint)
            canvas.restore()
        }
        fun update(stopcb:()->Unit) {

        }
        fun startUpdating(x:Float,y:Float,startcb:()->Unit) {

        }
    }
}