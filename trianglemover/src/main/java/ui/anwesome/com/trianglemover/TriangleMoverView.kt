package ui.anwesome.com.trianglemover

import android.app.Activity
import android.content.Context
import android.view.*
import android.graphics.*

/**
 * Created by anweshmishra on 26/12/17.
 */
class TriangleMoverView(ctx:Context):View(ctx) {
    val paint = Paint(Paint.ANTI_ALIAS_FLAG)
    val renderer = TriangleMoverRenderer(this)
    override fun onDraw(canvas:Canvas) {
        renderer.render(canvas,paint)
    }
    override fun onTouchEvent(event:MotionEvent):Boolean {
        when(event.action) {
            MotionEvent.ACTION_DOWN -> {
                renderer.handleTap(event.x,event.y)
            }
        }
        return true
    }
    data class TriangleMover(var x:Float,var y:Float,var size:Float,var deg:Float = 0f,var targetDeg:Float = 0f) {
        val animatorQueue = AnimatorQueue()
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
            animatorQueue.update(stopcb)
        }
        fun startUpdating(new_x:Float,new_y:Float,startcb:()->Unit) {
            targetDeg = DirectionUtil.angle_from_xy(new_x,new_y,this.x,this.y)
            animatorQueue.addAnimation { scale ->
                deg = targetDeg*scale
            }
            animatorQueue.addAnimation { scale ->
                this.x = this.x+(new_x - this.x)*scale
                this.y = this.y+(new_y - this.y)*scale
            }
            animatorQueue.addAnimation { scale ->
                deg = targetDeg*(1-scale)
            }
            startcb()
        }
    }
    data class TriangleMoverRenderer(var view:TriangleMoverView,var time:Int = 0) {
        var animator = TriangleViewAnimator(view)
        var triangleMover:TriangleMover?=null
        fun render(canvas:Canvas,paint:Paint) {
            if(time == 0) {
                val w = canvas.width.toFloat()
                val h = canvas.height.toFloat()
                triangleMover = TriangleMover(w/2,h/2,Math.min(w,h)/15)
            }
            canvas.drawColor(Color.parseColor("#212121"))
            triangleMover?.draw(canvas,paint)
            animator.update {
                triangleMover?.update(animator.stopAnimation)
            }
        }
        fun handleTap(x:Float,y:Float) {
            triangleMover?.startUpdating(x,y,animator.startAnimation)
        }
    }
    companion object {
        fun create(activity:Activity):TriangleMoverView {
            val view:TriangleMoverView = TriangleMoverView(activity)
            activity.setContentView(view)
            return view
        }
    }
}