package com.vinylsMobile.vinylsApplication.data.repository

import com.google.gson.JsonObject
import com.vinylsMobile.vinylsApplication.data.api.ApiHelper
import com.vinylsMobile.vinylsApplication.data.model.TracksResponse

class AlbumRepository(private val apiHelper: ApiHelper) {

    suspend fun getAlbums() = apiHelper.getAlbums()

    suspend fun getAlbumDetail(id: String) = apiHelper.getAlbumDetail(id)

    suspend fun postAlbumTrack(id:String, track: JsonObject) = apiHelper.postAlbumTrack(id,track)
}