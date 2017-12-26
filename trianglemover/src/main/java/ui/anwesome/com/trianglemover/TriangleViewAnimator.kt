package ui.anwesome.com.trianglemover

import android.view.View

/**
 * Created by anweshmishra on 26/12/17.
 */
class TriangleViewAnimator(var view:View,var animated:Boolean = false) {
    var startAnimation:()->Unit = {
        if(!animated) {
            animated = true
            view.postInvalidate()
        }
    }
    var stopAnimation:()->Unit = {
        if(animated) {
            animated = true
        }
    }
    fun update(updatecb:()->Unit) {
        if(animated) {
            updatecb()
            try {
                Thread.sleep(50)
                view.invalidate()
            }
            catch(ex:Exception) {

            }
        }
    }
}