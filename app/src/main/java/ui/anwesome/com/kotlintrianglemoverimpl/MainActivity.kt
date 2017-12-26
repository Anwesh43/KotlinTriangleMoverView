package ui.anwesome.com.kotlintrianglemoverimpl

import android.app.Activity
import android.content.pm.ActivityInfo
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import ui.anwesome.com.trianglemover.TriangleMoverView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        TriangleMoverView.create(this)
        fullScreen()
        fixPortraitOrientation()
        hideActionBar()
    }
}
fun Activity.fullScreen() {
    window.addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN)
}
fun Activity.fixPortraitOrientation() {
    requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
}
fun AppCompatActivity.hideActionBar() {
    supportActionBar?.hide()
}