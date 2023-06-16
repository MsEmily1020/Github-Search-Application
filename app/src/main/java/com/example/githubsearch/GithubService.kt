package com.example.githubsearch

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path

data class GithubUser (
    val login : String,
    val avatar_url : String,
    val name : String,
    val public_repos : Int,
    val followers : Int,
    val following : Int,
    val company : String,
    val created_at : String
    )

data class GitHubRepos (
    val name : String,
    val html_url : String,
    val stargazers_count : Int,
    val watchers_count : Int,
    val forks_count : Int,
    val language : String
)

interface GithubService {
    @GET("/users/{username}")
    fun getUser(@Path("username") username : String) : Call<GithubUser>

    @GET("/users/{username}/repos")
    fun getUserRepos(@Path("username") username : String) : Call<List<GitHubRepos>>
}