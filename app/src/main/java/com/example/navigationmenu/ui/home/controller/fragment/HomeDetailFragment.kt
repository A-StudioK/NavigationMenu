package com.example.navigationmenu.ui.home.controller.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.navigationmenu.R
import com.example.navigationmenu.data.model.Post
import com.example.navigationmenu.data.network.RetrofitClient
import com.example.navigationmenu.data.network.database.Favorite
import com.example.navigationmenu.data.network.database.FavoriteDB
import com.example.navigationmenu.ui.home.adapter.PostAdapter
import com.example.navigationmenu.ui.home.adapter.PostDetailAdapter
import com.google.android.material.floatingactionbutton.FloatingActionButton
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeDetailFragment : Fragment(), PostDetailAdapter.OnFabFavoriteClickListener {
    private lateinit var rvHomeDetail: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        rvHomeDetail = view.findViewById(R.id.rvHomeDetail)
        loadHomeDetail()
    }

    private fun loadHomeDetail() {
        val sentPostDetail = arguments
        val postId = sentPostDetail?.getInt("id", 0)
        val apiPost = RetrofitClient.apiPostInterface.getPostById(postId!!)

        apiPost.enqueue(object : Callback<Post> {
            override fun onResponse(call: Call<Post>, response: Response<Post>) {
                if (response.isSuccessful){
                    val post: Post = response.body()!!
                    rvHomeDetail.layoutManager = LinearLayoutManager(context)
                    rvHomeDetail.adapter = PostDetailAdapter(post, this@HomeDetailFragment)
                }
                else {
                    response.code()
                }
            }
            override fun onFailure(call: Call<Post>, t: Throwable) {
                Log.e("API Error", "Error: ${t.message}")
            }
        })
    }

    override fun onFabFavoriteClicked(post: Post) {
        val apiPostFavorite = RetrofitClient.apiPostInterface.insertPost(post)
        apiPostFavorite.enqueue(object : Callback<Post> {
            override fun onResponse(call: Call<Post>, response: Response<Post>) {
                if (response.isSuccessful){
                    val favorite: Post = response.body()!!
                    val favoriteObject = Favorite(
                        id = null,
                        title = favorite.title,
                        body = favorite.body
                    )
                    FavoriteDB.getInstance(requireContext()).getFavoriteDAO().insertFavorite(favoriteObject)
                    Log.e("API GO", "GO: ${post.id}")
                }
                else {
                    response.code()
                }
            }
            override fun onFailure(call: Call<Post>, t: Throwable) {
                Log.e("API Error", "Error: ${t.message}")
            }
        })
    }
}