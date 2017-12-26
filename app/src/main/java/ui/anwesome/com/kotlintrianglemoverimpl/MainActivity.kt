package ui.anwesome.com.kotlintrianglemoverimpl

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import ui.anwesome.com.trianglemover.TriangleMoverView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        TriangleMoverView.create(this)
    }
}
