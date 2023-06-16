package com.example.githubsearch

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RepositoryActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_repository)

        supportActionBar?.hide()

        val list = findViewById<RecyclerView>(R.id.repo_list)
        list.setHasFixedSize(false)
        list.layoutManager = LinearLayoutManager(this)

        val userId = intent.getStringExtra("user_id")

        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.github.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val githubService = retrofit.create(GithubService::class.java)


        val callRepos = githubService.getUserRepos(userId.toString());


        callRepos.enqueue(object : Callback<List<GitHubRepos>> {
            override fun onResponse(
                call: Call<List<GitHubRepos>>,
                response: Response<List<GitHubRepos>>
            ) {
                val repos = response.body() as List<GitHubRepos>
                repos?.let {
                    list.adapter = RepoListAdapter(it)
                }
            }

            override fun onFailure(call: Call<List<GitHubRepos>>, t: Throwable) {
            }
        })
    }
}