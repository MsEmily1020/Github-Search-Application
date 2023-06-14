package com.example.githubsearch

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
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

        val githubService = retrofit.create(GithubService::class.java)

        val loadingText = findViewById<TextView>(R.id.loading_text)
        val searchText = findViewById<EditText>(R.id.search_text)
        val searchBtn = findViewById<Button>(R.id.search_btn)

        searchBtn.setOnClickListener {
            loadingText.visibility = View.VISIBLE

            val username = searchText.text.trim().toString().replace(" ", "")

            val call = githubService.getUser(username)

            call.enqueue(object : Callback<GithubUser> {
                override fun onResponse(call: Call<GithubUser>, response: Response<GithubUser>) {
                    TODO("Not yet implemented")
                    loadingText.visibility = View.GONE
                }

                override fun onFailure(call: Call<GithubUser>, t: Throwable) {
                    TODO("Not yet implemented")
                }

            })
        }
    }
}