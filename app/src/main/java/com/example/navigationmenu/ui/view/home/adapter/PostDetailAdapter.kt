package com.example.navigationmenu.ui.view.home.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.example.navigationmenu.R
import com.example.navigationmenu.data.model.Post

class PostDetailAdapter(private val post: Post) : Adapter<PostDetailAdapter.ViewHolder>() {
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.prototype_post_detail, parent, false)
        return ViewHolder(view)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemView.findViewById<TextView>(R.id.tvUserIdDetail).text = "User ID: " + post.userId
        holder.itemView.findViewById<TextView>(R.id.tvIdDetail).text = "ID: " + post.id.toString()
        holder.itemView.findViewById<TextView>(R.id.tvTitleDetail).text = "Title: " + post.title
        holder.itemView.findViewById<TextView>(R.id.tvBodyDetail).text = "Body: " + post.body
    }

    override fun getItemCount(): Int {
        return 1
    }
}