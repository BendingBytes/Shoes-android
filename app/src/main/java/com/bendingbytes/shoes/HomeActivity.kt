package com.bendingbytes.shoes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import com.bendingbytes.shoes.fragments.FavouritesFragment
import com.bendingbytes.shoes.fragments.ListFragments
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        Log.d("HomeActivity", "Bbytes onCreate")


        //bottom navigation
        val favouritesFragment = FavouritesFragment()
        val listFragment = ListFragments()
        replaceCurrentFragment(listFragment)

        bottomNavigation.setOnItemSelectedListener {
            when (it.itemId){
                R.id.menuItemList -> replaceCurrentFragment(listFragment)
                R.id.menuItemFavorites -> replaceCurrentFragment(favouritesFragment)
            }
            true
        }
    }

    private fun replaceCurrentFragment(fragments: Fragment) =
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fragmentContainer, fragments)
            commit()
        }

}