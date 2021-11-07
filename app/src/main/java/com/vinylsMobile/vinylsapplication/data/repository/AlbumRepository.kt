package com.vinylsMobile.vinylsapplication.data.repository

import com.vinylsMobile.vinylsapplication.data.api.ApiHelper

class AlbumRepository(private val apiHelper: ApiHelper) {

     suspend fun getAlbums() = apiHelper.getAlbums()

     suspend fun getAlbumDetail(id:String) = apiHelper.getAlbumDetail(id)
}