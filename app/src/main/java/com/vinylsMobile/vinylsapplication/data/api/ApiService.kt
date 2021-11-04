package com.vinylsMobile.vinylsapplication.data.api


import com.vinylsMobile.vinylsapplication.data.model.albumResponse
import io.reactivex.Single

interface ApiService {
        fun getAlbums(): Single<List<albumResponse>>
}