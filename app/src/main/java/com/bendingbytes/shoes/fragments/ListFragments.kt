package com.bendingbytes.shoes.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.bendingbytes.shoes.R
import com.bendingbytes.shoes.view.ShoeModel


class ListFragments : Fragment() {

    private val shoeModel: ShoeModel by activityViewModels<ShoeModel>()

    override fun onViewCreated(shoeModel: View, savedInstanceState: Bundle?) {
        super.onViewCreated(shoeModel, savedInstanceState)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_list, container, false)
    companion object {
        fun newInstance() = ListFragments()
    }
}