package com.vinylsMobile.vinylsapplication.data.api


import com.vinylsMobile.vinylsapplication.data.model.albumResponse
import io.reactivex.Single
import retrofit2.http.GET

interface ApiService {
        @GET("albums")
        suspend fun getAlbums(): List<albumResponse>
}