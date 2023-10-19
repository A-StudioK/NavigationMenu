package com.example.navigationmenu.ui.view.home.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.navigationmenu.data.model.Post

class PostViewModel : ViewModel() {
    private val _posts = MutableLiveData<List<Post>>()

    val posts: LiveData<List<Post>> = _posts

    fun setPosts(postsList: List<Post>) {
        _posts.value = postsList
    }
}