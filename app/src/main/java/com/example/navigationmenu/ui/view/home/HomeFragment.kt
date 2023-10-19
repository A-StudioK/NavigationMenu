package com.example.navigationmenu.ui.view.home

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.navigationmenu.R
import com.example.navigationmenu.data.model.Post
import com.example.navigationmenu.data.network.RetrofitClient
import com.example.navigationmenu.ui.view.home.adapter.PostAdapter
import com.example.navigationmenu.ui.view.home.adapter.PostDetailAdapter
import com.google.android.material.floatingactionbutton.FloatingActionButton
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class HomeFragment : Fragment(), PostAdapter.OnItemClickListener {
    lateinit var postRecyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        postRecyclerView = view.findViewById(R.id.rvHome)
        loadPosts(view.context)
    }

    private fun loadPosts(context: Context?) {
        val apiAllPosts = RetrofitClient.apiPostInterface.getAllPosts()

        apiAllPosts.enqueue(object : Callback<List<Post>> {
            override fun onResponse(call: Call<List<Post>>, response: Response<List<Post>>) {
                if (response.isSuccessful){
                    val posts : List<Post> = response.body()!!
                    postRecyclerView.layoutManager = LinearLayoutManager(context)
                    postRecyclerView.adapter = PostAdapter(posts, this@HomeFragment)
                }
                else {
                    response.code()
                }
            }
            override fun onFailure(call: Call<List<Post>>, t: Throwable) {
                Log.e("API Error", "Error: ${t.message}")
            }
        })
    }

    override fun onItemClicked(post: Post) {
        postRecyclerView.adapter = PostDetailAdapter(post)
    }
}