package com.vinylsMobile.vinylsapplication.data.repository

import com.vinylsMobile.vinylsapplication.data.api.ApiHelper

class CollectorRepository(private val apiHelper: ApiHelper) {

     suspend fun getCollectors() = apiHelper.getCollectors()
}