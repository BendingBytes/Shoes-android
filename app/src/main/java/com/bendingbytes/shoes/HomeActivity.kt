package com.bendingbytes.shoes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import com.bendingbytes.shoes.Fragments.FavouritesFragment
import com.bendingbytes.shoes.Fragments.ListFragment
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.activity_splash.*

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        Log.d("HomeActivity", "Bbytes onCreate")


        //bottom navigation
        val favouritesFragment= FavouritesFragment()
        val listFragment= ListFragment()
        makeCurrentFragment(listFragment)
        bottom_navigation.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.ic_baseline_format_list_numbered -> makeCurrentFragment (listFragment)
                R.id.ic_baseline_star -> makeCurrentFragment (favouritesFragment)
            }
            true
        }
    }

    private fun makeCurrentFragment(fragment: Fragment) =
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.bottom_navigation, fragment)
            commit()
        }

    override fun onStart() {
        super.onStart()
        Log.d("HomeActivity", "Bbytes onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d("HomeActivity", "Bbytes onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d("HomeActivity", "Bbytes onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d("HomeActivity", "Bbytes onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("HomeActivity", "Bbytes onDestroy")
    }
}