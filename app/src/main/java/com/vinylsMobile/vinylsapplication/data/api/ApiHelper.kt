package com.vinylsMobile.vinylsapplication.data.api

import com.rx2androidnetworking.Rx2AndroidNetworking
import com.vinylsMobile.vinylsapplication.data.model.albumResponse
import io.reactivex.Single

class ApiHelper(private val apiService: ApiService) {

    fun getAlbums() = apiService.getAlbums()

}