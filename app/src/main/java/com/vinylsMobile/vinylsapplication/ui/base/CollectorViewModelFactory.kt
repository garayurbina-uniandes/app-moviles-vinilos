package com.vinylsMobile.vinylsapplication.ui.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.vinylsMobile.vinylsapplication.data.api.ApiHelper
import com.vinylsMobile.vinylsapplication.data.repository.AlbumRepository
import com.vinylsMobile.vinylsapplication.data.repository.ArtistRepository
import com.vinylsMobile.vinylsapplication.data.repository.CollectorRepository
import com.vinylsMobile.vinylsapplication.ui.main.viewmodel.ArtistViewModel
import com.vinylsMobile.vinylsapplication.ui.main.viewmodel.CollectorViewModel
import com.vinylsMobile.vinylsapplication.ui.main.viewmodel.MainViewModel

class CollectorViewModelFactory (private val apiHelper: ApiHelper) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(CollectorViewModel::class.java)) {
            return CollectorViewModel(CollectorRepository(apiHelper)) as T
        }
        throw IllegalArgumentException("Clase desconocida")
    }

    }