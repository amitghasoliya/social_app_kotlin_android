package com.example.socialapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.RelativeLayout
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat

class welcome : AppCompatActivity() {
    lateinit var feedsButton: RelativeLayout
    lateinit var uploadImage: RelativeLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        window.statusBarColor = ContextCompat.getColor(this, R.color.white)
        val windowInsetController = ViewCompat.getWindowInsetsController(window.decorView)
        windowInsetController?.isAppearanceLightStatusBars = true
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)

        feedsButton = findViewById(R.id.feedsButton)
        feedsButton.setOnClickListener{
            val intent = Intent(this, feeds::class.java)
            startActivity(intent)
        }
        uploadImage = findViewById(R.id.uploadImage)
        uploadImage.setOnClickListener{
            val intent = Intent(this, upload_image::class.java)
            startActivity(intent)
        }
    }
}