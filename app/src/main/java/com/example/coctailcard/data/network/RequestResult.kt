package com.example.coctailcard.data.network

sealed class RequestResult<out T : Any> {
    data class Success<out T : Any>(val data: T) : RequestResult<T>()
    data class Error(val throwable: Throwable) : RequestResult<Nothing>()
}
