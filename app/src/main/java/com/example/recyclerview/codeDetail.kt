package com.example.recyclerview

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class codeDetail : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_code_detail)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val heading = intent.getStringExtra("heading")
        val image = intent.getIntExtra("imageId", R.drawable.gfg)
        val content = intent.getStringExtra("content")

        val headingTv = findViewById<TextView>(R.id.codeHeading)
        val imageTv = findViewById<ImageView>(R.id.codeImage)
        val contentTv = findViewById<TextView>(R.id.codeContent)

        headingTv.text = heading
        contentTv.text = content
        imageTv.setImageResource(image)





    }
}


