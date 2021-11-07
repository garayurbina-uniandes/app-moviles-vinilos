package com.vinylsMobile.vinylsapplication.data.api


import com.vinylsMobile.vinylsapplication.data.model.albumResponse

import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
        @GET("albums")
        suspend fun getAlbums(): List<albumResponse>

        @GET("albums/{id}")
        suspend fun getAlbumDetail(@Path("id") id: String): albumResponse
}