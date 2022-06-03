package com.bendingbytes.shoes

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.util.Log
import androidx.fragment.app.Fragment
import com.bendingbytes.shoes.Fragments.FavouritesFragment
import com.bendingbytes.shoes.Fragments.ListFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_splash.*

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        animationView.postDelayed(Runnable { moveToHome() }, 3000)
        Log.d("SplashActivity", "Bbytes onCreate")

    }

    override fun onStart() {
        super.onStart()
        Log.d("SplashActivity", "Bbytes onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d("SplashActivity", "Bbytes onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d("SplashActivity", "Bbytes onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d("SplashActivity", "Bbytes onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("SplashActivity", "Bbytes onDestroy")
    }

    private fun moveToHome() {
        val intent = Intent(this, HomeActivity::class.java)
        startActivity(intent)
        finish()
    }
}