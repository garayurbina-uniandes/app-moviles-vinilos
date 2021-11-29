package com.vinylsMobile.vinylsApplication.ui.main.viewmodel


import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.vinylsMobile.vinylsApplication.data.api.RetrofitBuilder.apiService
import com.vinylsMobile.vinylsApplication.data.model.TracksResponse
import com.vinylsMobile.vinylsApplication.data.repository.AlbumRepository
import com.vinylsMobile.vinylsApplication.utils.Resource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainViewModel(private val AlbumRepository: AlbumRepository) : ViewModel() {
    fun getAlbums() = liveData(Dispatchers.IO) {
        emit(Resource.loading(data = null))
        try {
            emit(Resource.success(data = AlbumRepository.getAlbums()))
        } catch (exception: Exception) {
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

    fun createTrackToAlbum(name: String, duration: String, id: Number) = liveData(Dispatchers.IO) {

        emit(Resource.loading(data = null))
        try {
            val track = TracksResponse(name,duration)
            emit(Resource.success(data = AlbumRepository.postAlbumTrack(id.toString(), track.jsonPostString())))
        } catch (exception: Exception) {
            emit(Resource.error(data = null, msg = exception.message ?: "Un error ha ocurrido!"))
        }
    }

}