package com.vinylsMobile.vinylsapplication.ui.main.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.vinylsMobile.vinylsapplication.data.repository.AlbumRepository
import com.vinylsMobile.vinylsapplication.utils.Resource


import kotlinx.coroutines.Dispatchers

class MainViewModel(private val AlbumRepository: AlbumRepository): ViewModel() {
    fun getAlbums() = liveData(Dispatchers.IO) {
    emit(Resource.loading(data = null))
        Log.d("esta"," llamando")
    try {
        emit(Resource.success(data = AlbumRepository.getAlbums()))
    } catch (exception: Exception) {
        Log.d("Puteada",exception.message!!)
        emit(Resource.error(data = null, msg = exception.message ?: "Un error ha ocurrido!"))
    }
}

    fun getAlbumDetail(id: String) = liveData(Dispatchers.IO) {
        emit(Resource.loading(data = null))
        try {
            emit(Resource.success(data = AlbumRepository.getAlbumDetail(id)))
        } catch (exception: Exception) {
            emit(Resource.error(data = null, msg = exception.message ?: "Un error ha ocurrido!"))
        }
    }
}