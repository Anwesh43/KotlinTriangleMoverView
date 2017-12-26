package ui.anwesome.com.trianglemover

/**
 * Created by anweshmishra on 26/12/17.
 */
class DirectionUtil {
    companion object {
        fun angle_from_xy(x:Float,y:Float,px:Float,py:Float):Float {
            val x_diff = (x - px).toDouble()
            val y_diff = (y - py).toDouble()
            if(x_diff == 0.0) {
                if(y_diff >=0) {
                    return 90f
                }
                return 270f
            }
            else {
                var deg = (Math.atan(Math.abs(y_diff)/Math.abs(x_diff))*(180/(Math.PI))).toFloat()
                var deg_factor = y_diff/x_diff
                if(deg_factor>=0) {
                    if(x_diff > 0) {
                        return deg
                    }
                    return deg+180
                }
                else {
                    if(x_diff > 0) {
                        return 360-deg
                    }
                    else {
                        return 180-deg
                    }
                }
            }
            return 0f
        }
    }
}