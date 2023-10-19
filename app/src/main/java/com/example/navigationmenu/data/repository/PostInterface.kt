package com.example.navigationmenu.data.repository

import com.example.navigationmenu.data.model.Post
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface PostInterface {
    @GET("/posts")
    fun getAllPosts(): Call<List<Post>>

    @POST("/posts")
    fun insertPost(@Body post: Post): Call<Post>

    @DELETE("/posts/{id}")
    fun deletePost(@Path("id") postId: Int): Call<Void>
}