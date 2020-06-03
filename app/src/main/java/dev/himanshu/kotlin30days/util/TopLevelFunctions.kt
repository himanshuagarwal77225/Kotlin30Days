package dev.himanshu.kotlin30days.util

import dev.himanshu.kotlin30days.network.NetworkResult

suspend fun<T> safeApiCall(
    call: suspend () -> T,
    onSuccess: (NetworkResult.Success<T>) -> Unit,
    onFailure: (NetworkResult.Error) -> Unit
) {
    runCatching {
        val response = call()
        onSuccess(NetworkResult.Success(response))
    }.onFailure { message ->
        onFailure(NetworkResult.Error(message.message.toString()))
    }
}