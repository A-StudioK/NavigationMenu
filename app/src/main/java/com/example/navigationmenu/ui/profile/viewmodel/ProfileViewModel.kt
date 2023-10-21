package com.example.navigationmenu.ui.profile.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.navigationmenu.data.model.User
import com.example.navigationmenu.data.network.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ProfileViewModel : ViewModel() {
    private val userData = MutableLiveData<User>()
    fun getUserById(userId: Int): LiveData<User> {
        val apiUserProfile = RetrofitClient.apiUserInterface.getUserById(userId)
        apiUserProfile.enqueue(object : Callback<User> {
            override fun onResponse(call: Call<User>, response: Response<User>) {
                if (response.isSuccessful){
                    userData.postValue(response.body())
                }
                else {
                    response.code()
                }
            }
            override fun onFailure(call: Call<User>, t: Throwable) {
                Log.e("API Error", "Error: ${t.message}")
            }
        })
        return userData
    }
}