package com.example.navigationmenu.data.network

import com.example.navigationmenu.data.repository.PostInterface
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    private const val BASE_URL = "https://jsonplaceholder.typicode.com/"

    private val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val apiPostInterface: PostInterface by lazy {
        retrofit.create(PostInterface::class.java)
    }
}