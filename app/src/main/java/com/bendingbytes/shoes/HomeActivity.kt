package com.bendingbytes.shoes

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.room.Room
import com.bendingbytes.shoes.fragments.FavouritesFragment
import com.bendingbytes.shoes.fragments.ListFragments
import com.bendingbytes.shoes.network.ShoeClient
import com.bendingbytes.shoes.network.ShoeNetworkMapper
import com.bendingbytes.shoes.repository.ShoesRepository
import com.bendingbytes.shoes.room.ShoeCacheMapper
import com.bendingbytes.shoes.room.ShoeDb
import com.bendingbytes.shoes.view.ShoeViewModel
import com.bendingbytes.shoes.view.ShoeViewModelFactory
import kotlinx.android.synthetic.main.activity_home.*


class HomeActivity : AppCompatActivity() {

    private val favouritesFragment = FavouritesFragment.newInstance()
    private val listFragment = ListFragments.newInstance()
    private var currentFragment: Fragment = listFragment


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)


        Log.d("HomeActivity", "Bbytes onCreate")
        //bottom navigation
        initiateAllFragments()
        bottomNavigation.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.menuItemList -> showFragment(listFragment)
                R.id.menuItemFavorites -> showFragment(favouritesFragment)
            }
            true
        }
    }

    private fun showFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().apply {
            hide(currentFragment)
            show(fragment)
            currentFragment = fragment
            commit()
        }
    }

    private fun initiateAllFragments() {
        supportFragmentManager.beginTransaction().apply {
            add(R.id.fragmentContainer, listFragment)
            add(R.id.fragmentContainer, favouritesFragment).hide(favouritesFragment)
            commit()
        }
    }
}