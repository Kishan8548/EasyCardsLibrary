package com.kishan.easycardslibrary

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.easycards.EasyCardView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val cardExtra = findViewById<EasyCardView>(R.id.card_extra)
        
        val customButton = android.widget.Button(this).apply {
            text = "Explore Activities"
            setTextColor(android.graphics.Color.WHITE)
            setBackgroundColor(android.graphics.Color.parseColor("#44000000"))
            layoutParams = android.widget.LinearLayout.LayoutParams(
                android.widget.LinearLayout.LayoutParams.WRAP_CONTENT,
                android.widget.LinearLayout.LayoutParams.WRAP_CONTENT
            ).apply { topMargin = 16 }
        }
        
        cardExtra.addCustomContentView(customButton)
    }
}