package com.example.socialapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContract
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat

class upload_image : AppCompatActivity() {
    lateinit var img: ImageView
    lateinit var back: ImageView
    lateinit var selectImg: RelativeLayout
    lateinit var uploadButton: RelativeLayout

    private val contract = registerForActivityResult(ActivityResultContracts.GetContent()){
        img.setImageURI(it)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        window.statusBarColor = ContextCompat.getColor(this, R.color.white)
        val windowInsetController = ViewCompat.getWindowInsetsController(window.decorView)
        windowInsetController?.isAppearanceLightStatusBars = true

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_upload_image)
        img = findViewById(R.id.img)
        back = findViewById(R.id.back)
        selectImg = findViewById(R.id.selectImg)
        uploadButton = findViewById(R.id.uploadButton)

        back.setOnClickListener {
            finish()
        }
        selectImg.setOnClickListener {
            contract.launch("image/*")
        }
        uploadButton.setOnClickListener{
            var toast = Toast.makeText(this, "No Functionality", Toast.LENGTH_LONG)
            toast.show()
        }


    }
}