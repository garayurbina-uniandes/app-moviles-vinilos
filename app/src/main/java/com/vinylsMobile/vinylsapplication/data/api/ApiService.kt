package com.vinylsMobile.vinylsapplication.data.api


import com.vinylsMobile.vinylsapplication.data.model.AlbumResponse
import com.vinylsMobile.vinylsapplication.data.model.ArtistResponse

import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
        @GET("albums")
        suspend fun getAlbums(): List<AlbumResponse>

        @GET("albums/{id}")
        suspend fun getAlbumDetail(@Path("id") id: String): AlbumResponse

        @GET("musicians")
        suspend fun getMusicians(): List<ArtistResponse>

        @GET("bands")
        suspend fun getBands(): List<ArtistResponse>

        @GET("musicians/{id}")
        suspend fun getMusiciansDetail(@Path("id") id: String): ArtistResponse

        @GET("bands/{id}")
        suspend fun getBandsDetail(@Path("id") id: String): ArtistResponse
}