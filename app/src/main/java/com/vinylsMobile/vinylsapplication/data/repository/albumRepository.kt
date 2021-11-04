package com.vinylsMobile.vinylsapplication.data.repository

import com.vinylsMobile.vinylsapplication.data.api.ApiHelper
import com.vinylsMobile.vinylsapplication.data.model.albumResponse
import io.reactivex.Single

class albumRepository(private val apiHelper: ApiHelper) {

    fun getAlbums(): Single<List<albumResponse>> {
        return apiHelper.getAlbums()
    }
}