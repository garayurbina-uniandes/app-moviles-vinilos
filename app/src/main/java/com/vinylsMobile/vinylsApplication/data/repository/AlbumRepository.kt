package com.vinylsMobile.vinylsApplication.data.repository

import com.vinylsMobile.vinylsApplication.data.api.ApiHelper

class AlbumRepository(private val apiHelper: ApiHelper) {

     suspend fun getAlbums() = apiHelper.getAlbums()

     suspend fun getAlbumDetail(id:String) = apiHelper.getAlbumDetail(id)
}