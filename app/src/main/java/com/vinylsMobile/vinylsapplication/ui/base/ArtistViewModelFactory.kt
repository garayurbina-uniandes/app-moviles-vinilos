package com.vinylsMobile.vinylsapplication.ui.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.vinylsMobile.vinylsapplication.data.api.ApiHelper
import com.vinylsMobile.vinylsapplication.data.repository.AlbumRepository
import com.vinylsMobile.vinylsapplication.data.repository.ArtistRepository
import com.vinylsMobile.vinylsapplication.ui.main.viewmodel.ArtistViewModel
import com.vinylsMobile.vinylsapplication.ui.main.viewmodel.MainViewModel

class ArtistViewModelFactory (private val apiHelper: ApiHelper) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ArtistViewModel::class.java)) {
            return ArtistViewModel(ArtistRepository(apiHelper)) as T
        }
        throw IllegalArgumentException("Clase desconocida")
    }

    }