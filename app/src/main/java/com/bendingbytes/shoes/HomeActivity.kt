package com.bendingbytes.shoes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        Log.d("HomeActivity", "Bbytes onCreate")


        //bottom navigation
        val favouritesFragment = FavouritesFragment()
        val listFragment = ListFragment()
        makeCurrentFragment(listFragment)
        bottom_navigation.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.ic_baseline_format_list_numbered -> makeCurrentFragment(listFragment)
                R.id.ic_baseline_star -> makeCurrentFragment(favouritesFragment)
            }
            true
        }
    }

    private fun makeCurrentFragment(fragment: Fragment) =
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.constraintHome, fragment)
            commit()
        }

}