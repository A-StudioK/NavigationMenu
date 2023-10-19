package com.example.navigationmenu.data.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Post (
    @SerializedName("userId")
    var userId: Int,

    @SerializedName("id")
    val id: Int,

    @SerializedName("title")
    val title: String,

    @SerializedName("body")
    val body: String
)