package com.example.navigationmenu.data.network.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Favorite::class], version = 1)
abstract class FavoriteDB : RoomDatabase() {
    abstract fun getFavoriteDAO() : FavoriteDAO

    companion object {
        private var INSTANCE : FavoriteDB ?= null

        fun getInstance(context: Context) : FavoriteDB {
            if (INSTANCE == null) {
                INSTANCE = Room
                    .databaseBuilder(context, FavoriteDB::class.java, "favorite.db")
                    .allowMainThreadQueries()
                    .build()
            }
            return INSTANCE as FavoriteDB
        }
    }
}