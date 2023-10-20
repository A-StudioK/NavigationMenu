package com.example.navigationmenu.ui.favorite.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.example.navigationmenu.R
import com.example.navigationmenu.data.network.database.Favorite

class FavoriteAdapter(private val favorites: List<Favorite>) : Adapter<FavoriteAdapter.ViewHolder>() {
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.prototype_favorite, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val favorites = favorites[position]

        holder.itemView.findViewById<TextView>(R.id.tvIdFavorite).text = favorites.id.toString()
        holder.itemView.findViewById<TextView>(R.id.tvTitleFavorite).text = favorites.title
        holder.itemView.findViewById<TextView>(R.id.tvBodyFavorite).text = favorites.body
    }

    override fun getItemCount(): Int {
        return favorites.size
    }
}