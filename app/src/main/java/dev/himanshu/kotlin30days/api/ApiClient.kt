package dev.himanshu.kotlin30days.api

import dev.himanshu.kotlin30days.BuildConfig
import dev.himanshu.kotlin30days.model.PhotosResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiClient {
    @GET("/photos")
    suspend fun getPhotos(
        @Query("page") page: Int = 1,
        @Query("client_id") clientId: String = BuildConfig.API_KEY
    ): List<PhotosResponse>
}