package com.vinylsMobile.vinylsApplication.ui.main.viewmodel


import android.util.Log
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.google.gson.JsonObject
import com.vinylsMobile.vinylsApplication.data.api.RetrofitBuilder.apiService
import com.vinylsMobile.vinylsApplication.data.model.TracksModel
import com.vinylsMobile.vinylsApplication.data.model.TracksResponse
import com.vinylsMobile.vinylsApplication.data.repository.AlbumRepository
import com.vinylsMobile.vinylsApplication.utils.Resource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
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

    suspend fun createTrackToAlbum(name: String, duration: String, id: Number)  = withContext(Dispatchers.IO) {
        val track = TracksModel(name,duration)
        AlbumRepository.postAlbumTrack(id.toString(), jsonPostString(track.name,track.duration))
    }

    private fun jsonPostString(name:String, duration:String) : JsonObject {
        val paramObject = JsonObject()
        paramObject.addProperty("name", name)
        paramObject.addProperty("duration", duration)
        return paramObject
    }

}