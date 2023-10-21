package com.example.navigationmenu.data.model

import com.google.gson.annotations.SerializedName

data class User (
    @SerializedName("id")
    var id: Int,

    @SerializedName("name")
    var name: String,

    @SerializedName("email")
    var email: String,

    @SerializedName("phone")
    var phone: String,

    @SerializedName("website")
    var webSite: String
)