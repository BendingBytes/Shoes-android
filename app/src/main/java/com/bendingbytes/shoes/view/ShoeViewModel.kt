package com.bendingbytes.shoes.view


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.bendingbytes.shoes.domain.DataState
import com.bendingbytes.shoes.domain.Shoe
import com.bendingbytes.shoes.room.ShoeCacheMapper
import com.bendingbytes.shoes.room.ShoeDao
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import timber.log.Timber

class ShoeModel (private val shoeCacheMapper: ShoeCacheMapper,
                 private val shoeDao: ShoeDao,
                 private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO) : ViewModel()
{
    private val shoes: MutableLiveData<List<Shoe>> by lazy {
        MutableLiveData<List<Shoe>>().also {
            loadShoes(shoeCacheMapper, shoeDao , ioDispatcher)
        }
    }

    private fun loadShoes(shoeCacheMapper: ShoeCacheMapper,
                                shoeDao: ShoeDao,
                                ioDispatcher: CoroutineDispatcher = Dispatchers.IO) : Flow<DataState<List<Shoe>>> = flow {
        val shoesCacheEntities = shoeDao.getAll()
        val shoesDb = shoeCacheMapper.mapFromListEntity(shoesCacheEntities)
        emit(DataState.Success(shoesDb))
        Timber.i("Shoes are loaded")
    }.flowOn(ioDispatcher)

    fun getShoes(): LiveData<List<Shoe>> {
        return shoes
    }
}