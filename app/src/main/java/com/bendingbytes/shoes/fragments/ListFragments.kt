package com.bendingbytes.shoes.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.bendingbytes.shoes.R
import com.bendingbytes.shoes.view.ShoeViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ListFragments : Fragment() {

    private val shoeViewModel: ShoeViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        return (inflater.inflate(R.layout.fragment_list, container, false))
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        shoeViewModel.loadShoes()
    }

    companion object {
        fun newInstance() = ListFragments()
    }
}
