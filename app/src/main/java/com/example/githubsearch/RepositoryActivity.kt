package com.example.githubsearch

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class RepositoryActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_repository)

        val userId = intent.getStringExtra("user_id")

    }
}