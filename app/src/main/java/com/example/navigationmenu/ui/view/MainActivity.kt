package com.example.navigationmenu.ui.view

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.fragment.app.Fragment
import com.example.navigationmenu.R
import com.example.navigationmenu.ui.view.favorite.FavoriteFragment
import com.example.navigationmenu.ui.view.home.HomeFragment
import com.example.navigationmenu.ui.view.profile.ProfileFragment
import com.example.navigationmenu.ui.view.setting.SettingFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

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

    @SuppressLint("MissingSuperCall")
    @Deprecated("Deprecated in Java")
    override fun onBackPressed() {
        navigateTo(findViewById<BottomNavigationView>(R.id.bnvMenu).menu.findItem(R.id.miHome))
    }
}