package ui.anwesome.com.trianglemover

import java.util.*

/**
 * Created by anweshmishra on 26/12/17.
 */
class AnimatorQueue(var scale:Float = 0f,var dir:Float = 0f) {
    var animations:LinkedList<(Float)->Unit> = LinkedList()
    fun addAnimation(animation:(Float)->Unit) {
        animations.add(animation)
    }
    fun start() {
        dir = 1f
    }
    fun update(stopcb:()->Unit) {
        if(animations.size > 0) {
            scale += 0.1f*dir
            animations[0].invoke(scale)
            if(scale >= 1) {
                scale = 0f
                dir = 1f
                animations.removeFirst()
                if(animations.size == 0) {
                    dir = 0f
                    stopcb()
                }
            }
        }

    }
}