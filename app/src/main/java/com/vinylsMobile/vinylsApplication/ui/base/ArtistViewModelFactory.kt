package com.vinylsMobile.vinylsApplication.ui.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.vinylsMobile.vinylsApplication.data.api.ApiHelper
import com.vinylsMobile.vinylsApplication.data.repository.ArtistRepository
import com.vinylsMobile.vinylsApplication.ui.main.viewmodel.ArtistViewModel

class ArtistViewModelFactory (private val apiHelper: ApiHelper) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ArtistViewModel::class.java)) {
            return ArtistViewModel(ArtistRepository(apiHelper)) as T
        }
        throw IllegalArgumentException("Clase desconocida")
    }
    }