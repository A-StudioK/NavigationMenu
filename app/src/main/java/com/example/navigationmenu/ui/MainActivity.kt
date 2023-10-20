package com.example.navigationmenu.ui

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.fragment.app.Fragment
import com.example.navigationmenu.R
import com.example.navigationmenu.data.network.RetrofitClient
import com.example.navigationmenu.ui.favorite.controller.fragment.FavoriteFragment
import com.example.navigationmenu.ui.home.controller.fragment.HomeFragment
import com.example.navigationmenu.ui.profile.controller.fragment.ProfileFragment
import com.example.navigationmenu.ui.setting.controller.fragment.SettingFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.floatingactionbutton.FloatingActionButton

@Suppress("DEPRECATION")
class MainActivity : AppCompatActivity() {
    private val onNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item -> navigateTo(item) }

    private fun navigateTo(item: MenuItem) : Boolean {
        item.isChecked = true
        return supportFragmentManager
            .beginTransaction()
            .replace(R.id.flFragmentX, getFragmentFor(item))
            .commit() > 0
    }

    private fun getFragmentFor(item: MenuItem): Fragment {
        return when(item.itemId) {
            R.id.miHome -> HomeFragment()
            R.id.miFavorites -> FavoriteFragment()
            R.id.miProfile -> ProfileFragment()
            R.id.miSetting -> SettingFragment()
            else -> HomeFragment()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navView: BottomNavigationView = findViewById(R.id.bnvMenu)
        navView.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener)
        navigateTo(navView.menu.findItem(R.id.miHome))
    }

    @Deprecated("Deprecated in Java")
    override fun onBackPressed() {
        val fragmentManager = supportFragmentManager
        if (fragmentManager.backStackEntryCount > 0) {
            fragmentManager.popBackStack()
        } else {
            super.onBackPressed()
        }
    }
}