package com.vinylsMobile.vinylsapplication.data.api

import com.rx2androidnetworking.Rx2AndroidNetworking
import com.vinylsMobile.vinylsapplication.data.model.albumResponse
import io.reactivex.Single

class ApiServiceImpl: ApiService {
    override fun getAlbums(): Single<List<albumResponse>> {
        return Rx2AndroidNetworking.get("https://vinyl-miso.herokuapp.com/albums")
            .build()
            .getObjectListSingle(albumResponse::class.java)
    }

}