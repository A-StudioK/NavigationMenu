package com.example.navigationmenu.data.network.database

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import java.io.Serializable

@Entity(tableName = "favorites")
class Favorite (
    @PrimaryKey(autoGenerate = true)
    @SerializedName("id")
    val id: Int? = 0,

    @SerializedName("title")
    val title: String,

    @SerializedName("body")
    val body: String
) : Serializable