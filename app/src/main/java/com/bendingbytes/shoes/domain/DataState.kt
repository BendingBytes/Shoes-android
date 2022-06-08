package com.bendingbytes.shoes.domain

import com.bendingbytes.shoes.R


sealed class DataState<out R> {
    object Loading : DataState <Nothing>()
    //data class Error(val throwable: Throwable) : DataState <Nothing>()
    //data class Success (val data : List<String>) : DataState<Nothing>()

    data class Success<out R : Any>(val value: R) : DataState<R>()
    data class Error(val message: String, val throwable: Throwable? = null) : DataState<Nothing>()
}
