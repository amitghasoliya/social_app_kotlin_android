package com.example.socialapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat

class intro1 : AppCompatActivity() {
    lateinit var skipIntro: LinearLayout
    lateinit var next: CardView

    override fun onCreate(savedInstanceState: Bundle?) {
        window.statusBarColor = ContextCompat.getColor(this, R.color.white)
        val windowInsetController = ViewCompat.getWindowInsetsController(window.decorView)
        windowInsetController?.isAppearanceLightStatusBars = true

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intro1)

        skipIntro = findViewById(R.id.skipIntro)
        skipIntro.setOnClickListener{
            val intent = Intent(this, welcome::class.java)
            startActivity(intent)
        }

        next = findViewById(R.id.next)
        next.setOnClickListener{
            val intent = Intent(this, intro2::class.java)
            startActivity(intent)
        }
    }
}