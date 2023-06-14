package com.example.githubsearch

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()

        val loadingText = findViewById<TextView>(R.id.loading_text)
        val searchBtn = findViewById<Button>(R.id.search_btn)

        searchBtn.setOnClickListener {
            loadingText.visibility = View.VISIBLE
        }
    }
}