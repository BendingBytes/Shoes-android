package com.bendingbytes.shoes.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.room.Room
import com.bendingbytes.shoes.R
import com.bendingbytes.shoes.network.ShoeClient.service
import com.bendingbytes.shoes.network.ShoeNetworkMapper
import com.bendingbytes.shoes.repository.ShoesRepository
import com.bendingbytes.shoes.room.ShoeCacheMapper
import com.bendingbytes.shoes.room.ShoeDb
import com.bendingbytes.shoes.view.ShoeViewModel
import com.bendingbytes.shoes.view.ShoeViewModelFactory

class FavouritesFragment : Fragment() {

    private val shoeViewModel: ShoeViewModel by activityViewModels {
        val db = Room.databaseBuilder(
            requireContext(),
            ShoeDb::class.java, ShoeDb.DATABASE_NAME
        ).build()
        val shoeCacheMapper = ShoeCacheMapper()
        val shoeNetworkMapper = ShoeNetworkMapper()
        val shoeService = service
        val shoeDao = db.shoeDao()
        ShoeViewModelFactory(
            ShoesRepository(
                shoeNetworkMapper,
                shoeCacheMapper,
                shoeService,
                shoeDao
            )
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        return (inflater.inflate(R.layout.fragment_favourites, container, false))
    }

    companion object {
        fun newInstance() = FavouritesFragment()
    }
}

