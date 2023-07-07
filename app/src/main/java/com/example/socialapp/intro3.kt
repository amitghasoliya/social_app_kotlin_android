package com.example.socialapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat

class intro3 : AppCompatActivity() {
    lateinit var skipIntro: LinearLayout
    lateinit var ready: CardView


    override fun onCreate(savedInstanceState: Bundle?) {
        window.statusBarColor = ContextCompat.getColor(this, R.color.white)
        val windowInsetController = ViewCompat.getWindowInsetsController(window.decorView)
        windowInsetController?.isAppearanceLightStatusBars = true
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intro3)

        skipIntro = findViewById(R.id.skipIntro)
        skipIntro.setOnClickListener{
            val intent = Intent(this, welcome::class.java)
            startActivity(intent)
        }

        ready = findViewById(R.id.ready)
        ready.setOnClickListener{
            val intent = Intent(this, welcome::class.java)
            startActivity(intent)
        }
    }
}