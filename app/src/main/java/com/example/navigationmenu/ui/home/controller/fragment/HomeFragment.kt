package com.example.navigationmenu.ui.home.controller.fragment

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.navigationmenu.R
import com.example.navigationmenu.data.model.Post
import com.example.navigationmenu.data.network.RetrofitClient
import com.example.navigationmenu.ui.home.adapter.PostAdapter
import com.example.navigationmenu.ui.home.adapter.PostDetailAdapter
import com.google.android.material.floatingactionbutton.FloatingActionButton
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class HomeFragment : Fragment(), PostAdapter.OnItemClickListener {
    private lateinit var rvHome: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        rvHome = view.findViewById(R.id.rvHome)
        loadPosts(view.context)
    }

    private fun loadPosts(context: Context?) {
        val apiAllPosts = RetrofitClient.apiPostInterface.getAllPosts()

        apiAllPosts.enqueue(object : Callback<List<Post>> {
            override fun onResponse(call: Call<List<Post>>, response: Response<List<Post>>) {
                if (response.isSuccessful){
                    val posts : List<Post> = response.body()!!
                    rvHome.layoutManager = LinearLayoutManager(context)
                    rvHome.adapter = PostAdapter(posts, this@HomeFragment)
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

    @Suppress("DEPRECATION")
    override fun onItemClicked(post: Post) {
        val sendPostDetail = Bundle()
        sendPostDetail.putInt("id", post.id)

        val flHomeDetail = HomeDetailFragment()
        flHomeDetail.arguments = sendPostDetail

        requireFragmentManager().beginTransaction()
            .replace(R.id.flFragmentX, flHomeDetail)
            .addToBackStack(null)
            .commit()
    }
}