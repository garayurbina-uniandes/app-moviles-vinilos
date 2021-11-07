package com.vinylsMobile.vinylsapplication.ui.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.vinylsMobile.vinylsapplication.data.api.ApiHelper
import com.vinylsMobile.vinylsapplication.data.repository.AlbumRepository
import com.vinylsMobile.vinylsapplication.ui.main.viewmodel.MainViewModel

class ViewModelFactory (private val apiHelper: ApiHelper) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            return MainViewModel(AlbumRepository(apiHelper)) as T
        }
        throw IllegalArgumentException("Clase desconocida")
    }

    }