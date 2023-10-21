package com.example.navigationmenu.ui.profile.controller.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.viewModels
import com.example.navigationmenu.R
import com.example.navigationmenu.ui.profile.viewmodel.ProfileViewModel


class ProfileFragment : Fragment() {
    private val profileViewModel: ProfileViewModel by viewModels()
    private val userId = 1

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return  inflater.inflate(R.layout.fragment_profile, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        loadProfile(view)
    }

    private fun loadProfile(view: View) {
        profileViewModel.getUserById(userId).observe(viewLifecycleOwner) { user ->
            view.findViewById<TextView>(R.id.tvIdProfile).text = user.id.toString()
            view.findViewById<TextView>(R.id.tvNameProfile).text = user.name
            view.findViewById<TextView>(R.id.tvEmailProfile).text = user.email
            view.findViewById<TextView>(R.id.tvPhoneProfile).text = user.phone
            view.findViewById<TextView>(R.id.tvWebSiteProfile).text = user.webSite
            view.findViewById<ImageView>(R.id.ivLogo).setImageResource(R.drawable.logo)
        }
    }
}