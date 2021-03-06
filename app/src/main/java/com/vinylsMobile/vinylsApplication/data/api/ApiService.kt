package com.vinylsMobile.vinylsApplication.data.api


import com.google.gson.JsonObject
import com.vinylsMobile.vinylsApplication.data.model.AlbumResponse
import com.vinylsMobile.vinylsApplication.data.model.ArtistResponse
import com.vinylsMobile.vinylsApplication.data.model.CollectorResponse
import retrofit2.http.Body

import retrofit2.http.GET
import retrofit2.http.POST
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

    @GET("collectors")
    suspend fun getCollectors(): List<CollectorResponse>

    @GET("musicians/{id}")
    suspend fun getMusiciansDetail(@Path("id") id: String): ArtistResponse

    @GET("bands/{id}")
    suspend fun getBandsDetail(@Path("id") id: String): ArtistResponse

    @GET("collectors/{id}")
    suspend fun getCollectorsDetail(@Path("id") id: String): CollectorResponse

    @POST("albums/{id}/tracks")
    suspend fun postAlbumTrack(@Path("id") id: String, @Body track: JsonObject): AlbumResponse

    @POST("albums")
    suspend fun postAlbum(@Body album: JsonObject): AlbumResponse

}