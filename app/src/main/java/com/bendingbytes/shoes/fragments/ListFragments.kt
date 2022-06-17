package com.bendingbytes.shoes.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.bendingbytes.shoes.R
import com.bendingbytes.shoes.view.ShoeViewModel


class ListFragments : Fragment() {

    private val shoeViewModel: ShoeViewModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        shoeViewModel.loadShoes()
        return (inflater.inflate(R.layout.fragment_list, container, false))
    }
    companion object {
        fun newInstance() = ListFragments()
    }
}