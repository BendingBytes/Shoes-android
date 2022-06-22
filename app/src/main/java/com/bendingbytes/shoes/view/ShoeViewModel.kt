package com.bendingbytes.shoes.view


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bendingbytes.shoes.domain.DataState
import com.bendingbytes.shoes.domain.Shoe
import com.bendingbytes.shoes.repository.ShoesRepository
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import timber.log.Timber


class ShoeViewModel(
    private val shoesRepository: ShoesRepository,
) : ViewModel() {

    val shoeLiveDataState: LiveData<DataState<List<Shoe>>>
        get() = mutableShoeLiveDataState

    private val mutableShoeLiveDataState: MutableLiveData<DataState<List<Shoe>>> =
        MutableLiveData()

    fun loadShoes() {
        viewModelScope.launch {
            shoesRepository.getShoes()
                .onEach { dataState -> mutableShoeLiveDataState.postValue(dataState) }
                .launchIn(this)
        }
    }
    fun test(){

    }
}

