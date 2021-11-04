package com.vinylsMobile.vinylsapplication.ui.main.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.vinylsMobile.vinylsapplication.data.model.albumResponse
import com.vinylsMobile.vinylsapplication.data.repository.albumRepository
import com.vinylsMobile.vinylsapplication.utils.Resource
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class MainViewModel(private val albumRepository: albumRepository): ViewModel() {

    private val albums = MutableLiveData<Resource<List<albumResponse>>>()
    private val compositeDisposable = CompositeDisposable()

    init {
        fetchAlbums()
    }

    private fun fetchAlbums() {
        albums.postValue(Resource.loading(null))
        compositeDisposable.add(
            albumRepository.getAlbums()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ userList ->
                    albums.postValue(Resource.success(userList))
                }, { throwable ->
                    albums.postValue(Resource.error("No se pudo traer la lista", null))
                })
        )
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }

    fun getAlbums(): LiveData<Resource<List<albumResponse>>> {
        return albums
    }
}