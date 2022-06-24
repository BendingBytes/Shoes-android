package com.bendingbytes.shoes.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bendingbytes.shoes.R

class FavouritesFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        return (inflater.inflate(R.layout.fragment_favourites, container, false))
    }

    companion object {
        fun newInstance() = FavouritesFragment()
    }
}

