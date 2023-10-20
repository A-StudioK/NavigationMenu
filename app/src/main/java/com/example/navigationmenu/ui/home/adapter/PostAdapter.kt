package com.example.navigationmenu.ui.home.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.constraintlayout.widget.ConstraintSet
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.example.navigationmenu.R
import com.example.navigationmenu.data.model.Post


class PostAdapter(private val posts: List<Post>, private val itemClickListener: OnItemClickListener) : Adapter<PostAdapter.ViewHolder>() {
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    interface OnItemClickListener {
        fun onItemClicked(post: Post)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.prototype_post, parent, false)
        return ViewHolder(view)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val post = posts[position]
        holder.itemView.findViewById<TextView>(R.id.tvUserId).text = "User ID: " + post.userId
        holder.itemView.findViewById<TextView>(R.id.tvId).text = "ID: " + post.id.toString()
        holder.itemView.findViewById<TextView>(R.id.tvTitle).text = "Title: " + post.title
        holder.itemView.findViewById<TextView>(R.id.tvBody).text = "Body: " + post.body

        holder.itemView.findViewById<CardView>(R.id.cvPost).setOnClickListener {
            itemClickListener.onItemClicked(post)
        }
    }

    override fun getItemCount(): Int {
        return posts.size
    }
}