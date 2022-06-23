package com.bendingbytes.shoes.view

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.bendingbytes.shoes.repository.ShoesRepository

class ShoeViewModelFactory(private val shoesRepository: ShoesRepository)
    : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {

        if (modelClass.isAssignableFrom(ShoeViewModel::class.java)) {
            return ShoeViewModel(shoesRepository) as T
        }

        throw IllegalArgumentException("Unknown ViewModel class")
    }
}