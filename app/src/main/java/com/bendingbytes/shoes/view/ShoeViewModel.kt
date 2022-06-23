package com.bendingbytes.shoes.view

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bendingbytes.shoes.domain.DataState
import com.bendingbytes.shoes.domain.Shoe
import com.bendingbytes.shoes.repository.ShoesRepository
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch

class ShoeViewModel(private val shoesRepository: ShoesRepository) : ViewModel() {
    private val mutableShoeLiveData: MutableLiveData<DataState<List<Shoe>>> = MutableLiveData()

    fun loadShoes() {
        viewModelScope.launch {
            shoesRepository.getShoes()
                .onEach { dataState -> mutableShoeLiveData.postValue(dataState) }
                .launchIn(this)
        }
    }
}

