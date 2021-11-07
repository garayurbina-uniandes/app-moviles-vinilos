package com.vinylsMobile.vinylsapplication.data.api


class ApiHelper(private val apiService: ApiService) {

    suspend fun getAlbums() = apiService.getAlbums()
    suspend fun getAlbumDetail(id:String) = apiService.getAlbumDetail(id)

}