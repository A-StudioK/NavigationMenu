package com.example.navigationmenu.data.network.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.navigationmenu.data.model.Post

@Dao
interface FavoriteDAO {
    @Insert
    fun insertFavorite(vararg favorite: Favorite)

    @Query("SELECT * FROM favorites")
    fun getAllFavorites(): List<Favorite>

    @Delete
    fun deleteFavorite(vararg favorite: Favorite)

    @Update
    fun updateFavorite(vararg favorite: Favorite)
}