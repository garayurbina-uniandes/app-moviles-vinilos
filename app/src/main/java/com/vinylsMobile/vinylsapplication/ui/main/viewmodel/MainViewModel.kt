package com.vinylsMobile.vinylsapplication.ui.main.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.vinylsMobile.vinylsapplication.data.model.albumResponse
import com.vinylsMobile.vinylsapplication.data.repository.albumRepository
import com.vinylsMobile.vinylsapplication.utils.Resource


import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.Dispatchers

class MainViewModel(private val albumRepository: albumRepository): ViewModel() {
    fun getAlbums() = liveData(Dispatchers.IO) {
    emit(Resource.loading(data = null))
    try {
        emit(Resource.success(data = albumRepository.getAlbums()))
    } catch (exception: Exception) {
        emit(Resource.error(data = null, msg = exception.message ?: "Un error ha ocurrido!"))
    }
}
}