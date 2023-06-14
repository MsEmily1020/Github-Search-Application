package com.example.githubsearch

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class GithubUserActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_github_user)

        val userLogin = intent.getStringExtra("user_login")
        val userAvatarUrl = intent.getStringExtra("user_avatar_url")
        val userName = intent.getStringExtra("user_name")
        val userPublicRepos = intent.getStringExtra("user_public_repos")
        val userFollowers = intent.getStringExtra("user_followers")
        val userFollowing = intent.getStringExtra("user_following")
        val userCompany = intent.getStringExtra("user_company")
        val userCreatedAt = intent.getStringExtra("user_created_at")

    }
}