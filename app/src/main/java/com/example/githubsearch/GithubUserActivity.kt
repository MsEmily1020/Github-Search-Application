package com.example.githubsearch

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide

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

        val userLoginTextView = findViewById<TextView>(R.id.user_login)
        val userAvatarUrlImageView = findViewById<ImageView>(R.id.user_profile)
        val userNameTextView = findViewById<TextView>(R.id.user_name)
        val userPublicReposTextView = findViewById<TextView>(R.id.user_public_repos)
        val userFollowersFollowingTextView = findViewById<TextView>(R.id.user_followers_following)
        val userCompanyTextView = findViewById<TextView>(R.id.user_company)
        val userCreatedAtTextView = findViewById<TextView>(R.id.user_created_at)

        userLoginTextView.text = userLogin
        userNameTextView.text = userName
        userPublicReposTextView.text = userPublicRepos
        userFollowersFollowingTextView.text = "$userFollowers $userFollowing"
        userCompanyTextView.text = userCompany
        userCreatedAtTextView.text = userCreatedAt

        Glide.with(this)
            .load(userAvatarUrl)
            .into(userAvatarUrlImageView)
    }
}