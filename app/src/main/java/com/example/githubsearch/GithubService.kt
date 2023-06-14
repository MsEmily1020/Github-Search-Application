package com.example.githubsearch

import retrofit2.Call
import retrofit2.http.GET
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

interface GithubService {
    @GET("/users/{username}")
    fun getUser(@Path("username") username : String) : Call<GithubUser>
}