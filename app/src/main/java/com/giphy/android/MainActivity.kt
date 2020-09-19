package com.giphy.android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.giphy.android.ui.main.MainFragment
import com.giphy.android.util.actionGo.addFragment

class MainActivity : AppCompatActivity() {
    private val TAG  = MainActivity::class.java.simpleName
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            startMainFragment()
        }
    }

    private fun startMainFragment() {
        val fragment = MainFragment()
        addFragment(this,fragment,R.id.container,false)

    }


}
