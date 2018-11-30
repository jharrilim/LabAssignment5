package com.comp304.ass5

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun onContinueBtnClick(view: View?) {
        startActivity(Intent(this, CuisinesListActivity::class.java))
    }
}
