package com.example.navigationmenu.ui.view.home.controller.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.navigationmenu.R
import com.example.navigationmenu.data.model.Post
import com.example.navigationmenu.ui.view.home.adapter.PostDetailAdapter

class HomeDetailFragment : Fragment() {
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
        val userId = sentPostDetail?.getInt("userId")
        val id = sentPostDetail?.getInt("id")
        val title = sentPostDetail?.getString("title")
        val body = sentPostDetail?.getString("body")

        val post = Post(userId ?: 0, id ?: 0, title ?: "", body ?: "")

        rvHomeDetail.layoutManager = LinearLayoutManager(context)
        rvHomeDetail.adapter = PostDetailAdapter(post)
    }
}