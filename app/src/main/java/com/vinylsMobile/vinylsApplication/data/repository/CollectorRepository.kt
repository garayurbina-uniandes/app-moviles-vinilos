package com.vinylsMobile.vinylsApplication.data.repository

import com.vinylsMobile.vinylsApplication.data.api.ApiHelper

class CollectorRepository(private val apiHelper: ApiHelper) {

    suspend fun getCollectors() = apiHelper.getCollectors()
    suspend fun getCollectorsDetail(id: String) = apiHelper.getCollectorsDetail(id)
}