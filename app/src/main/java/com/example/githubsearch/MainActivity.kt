package com.example.githubsearch

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
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
            searchText.setText(username)

            val call = githubService.getUser(username)

            call.enqueue(object : Callback<GithubUser> {
                override fun onResponse(call: Call<GithubUser>, response: Response<GithubUser>) {
                    val user = response.body() as GithubUser

                    user?.let {
                        Log.d("mytag", user.toString())

                        val intent = Intent(this@MainActivity,
                            GithubUserActivity::class.java)

                        intent.putExtra("user_login", user.login)
                        intent.putExtra("user_avatar_url", user.avatar_url)
                        intent.putExtra("user_name", user.name)
                        intent.putExtra("user_public_repos", user.public_repos.toString())
                        intent.putExtra("user_followers", user.followers.toString())
                        intent.putExtra("user_following", user.following.toString())
                        intent.putExtra("user_company", user.company)
                        intent.putExtra("user_created_at", user.created_at)

                        startActivity(intent)
                    }

                    loadingText.visibility = View.GONE
                }

                override fun onFailure(call: Call<GithubUser>, t: Throwable) {
                }

            })
        }
    }
}