package com.vinylsMobile.vinylsapplication.data.api


import com.vinylsMobile.vinylsapplication.data.model.AlbumResponse

import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
        @GET("albums")
        suspend fun getAlbums(): List<AlbumResponse>

        @GET("albums/{id}")
        suspend fun getAlbumDetail(@Path("id") id: String): AlbumResponse
}