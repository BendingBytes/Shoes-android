package com.bendingbytes.shoes.view


import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bendingbytes.shoes.domain.DataState
import com.bendingbytes.shoes.domain.Shoe
import com.bendingbytes.shoes.repository.ShoesRepository
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import timber.log.Timber

class ShoeViewModel(
    private val shoesRepository: ShoesRepository,
) : ViewModel() {
    private val mutableShoeLiveDataState: MutableLiveData<DataState<List<Shoe>>> =
        MutableLiveData()


    @ExperimentalCoroutinesApi
    fun loadShoes(forceFetch: Boolean = false) {
        viewModelScope.launch {
            if (forceFetch) {
                shoesRepository.getShoes()
                    .onEach { dataState ->
                        mutableShoeLiveDataState.postValue(dataState)
                    }.catch {
                        Timber.e(it)
                        loadShoes(false) // fallback: load from DB
                    }.launchIn(this)
            } else {
                Timber.e("Error")
            }
        }
    }
}