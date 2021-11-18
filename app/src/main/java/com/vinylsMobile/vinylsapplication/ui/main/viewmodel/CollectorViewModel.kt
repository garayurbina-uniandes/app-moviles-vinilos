package com.vinylsMobile.vinylsapplication.ui.main.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.vinylsMobile.vinylsapplication.data.model.ArtistResponse
import com.vinylsMobile.vinylsapplication.data.repository.AlbumRepository
import com.vinylsMobile.vinylsapplication.data.repository.ArtistRepository
import com.vinylsMobile.vinylsapplication.data.repository.CollectorRepository
import com.vinylsMobile.vinylsapplication.utils.Resource


import kotlinx.coroutines.Dispatchers

class CollectorViewModel(private val CollectorRepository:CollectorRepository): ViewModel() {

    fun getColelctors() = liveData(Dispatchers.IO) {
        emit(Resource.loading(data = null))
        try {
            emit(Resource.success(data = CollectorRepository.getCollectors()))
        } catch (exception: Exception) {
            emit(Resource.error(data = null, msg = exception.message ?: "Un error ha ocurrido!"))
        }
    }
}