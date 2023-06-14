package com.example.githubsearch

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()

        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.github.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val loadingText = findViewById<TextView>(R.id.loading_text)
        val searchText = findViewById<EditText>(R.id.search_text)
        val searchBtn = findViewById<Button>(R.id.search_btn)

        searchBtn.setOnClickListener {
            loadingText.visibility = View.VISIBLE

            val username = searchText.text.trim().toString().replace(" ", "")
        }
    }
}