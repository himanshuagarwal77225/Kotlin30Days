package dev.himanshu.kotlin30days.repo

import dev.himanshu.kotlin30days.api.ApiClient
import dev.himanshu.kotlin30days.model.PhotosResponse
import dev.himanshu.kotlin30days.network.NetworkResult
import dev.himanshu.kotlin30days.util.safeApiCall

class MainRepo (private val apiClient: ApiClient) {

    suspend fun getPhotos(page: Int = 1): NetworkResult<List<PhotosResponse>> {
        var result: NetworkResult<List<PhotosResponse>>? = null

        safeApiCall({ apiClient.getPhotos(page) },
            { result = it },
            { result = it }
        )

        return result!!
    }
}