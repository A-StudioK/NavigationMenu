package com.example.navigationmenu.ui.favorite.controller.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.navigationmenu.R
import com.example.navigationmenu.data.network.database.Favorite
import com.example.navigationmenu.data.network.database.FavoriteDB
import com.example.navigationmenu.ui.favorite.adapter.FavoriteAdapter


class FavoriteFragment : Fragment() {
    private lateinit var rvFavorite: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_favorite, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        rvFavorite = view.findViewById(R.id.rvFavorite)
        loadFavorites(view)
    }

    private fun loadFavorites(view: View) {
        val favorites: List<Favorite> = FavoriteDB.getInstance(view.context).getFavoriteDAO().getAllFavorites()
        rvFavorite.layoutManager = LinearLayoutManager(context)
        rvFavorite.adapter = FavoriteAdapter(favorites)
    }
}