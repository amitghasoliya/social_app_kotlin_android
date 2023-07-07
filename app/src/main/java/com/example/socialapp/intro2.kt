package com.example.socialapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat

class intro2 : AppCompatActivity() {
    lateinit var skipIntro: LinearLayout
    lateinit var next1: CardView

    override fun onCreate(savedInstanceState: Bundle?) {
        window.statusBarColor = ContextCompat.getColor(this, R.color.white)
        val windowInsetController = ViewCompat.getWindowInsetsController(window.decorView)
        windowInsetController?.isAppearanceLightStatusBars = true
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intro2)

        skipIntro = findViewById(R.id.skipIntro)
        skipIntro.setOnClickListener{
            val intent = Intent(this, welcome::class.java)
            startActivity(intent)
        }

        next1 = findViewById(R.id.next1)
        next1.setOnClickListener{
            val intent = Intent(this, intro3::class.java)
            startActivity(intent)
        }
    }
}