package com.example.navigationmenu.data.repository

import com.example.navigationmenu.data.model.User
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface UserInterface {
    @GET("/users")
    fun getAllUsers(): Call<List<User>>

    @GET("/users/{id}")
    fun getUserById(@Path("id") userId: Int): Call<User>

    @POST("/users")
    fun insertUser(@Body user: User): Call<User>

    @DELETE("/users/{id}")
    fun deleteUser(@Path("id") userId: Int): Call<Void>
}