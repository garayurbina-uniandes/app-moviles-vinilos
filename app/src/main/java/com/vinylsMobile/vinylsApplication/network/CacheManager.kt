package com.vinylsMobile.vinylsApplication.network

import android.content.Context
import com.vinylsMobile.vinylsApplication.data.model.ArtistResponse

class CacheManager(context: Context) {
    companion object{
        var instance: CacheManager? = null
        fun getInstance(context: Context) =
            instance ?: synchronized(this) {
                instance ?: CacheManager(context).also {
                    instance = it
                }
            }
    }
    private var artists: HashMap<Int, ArtistResponse> = hashMapOf()

    fun addArtists(artistId: Int, artista: ArtistResponse){
        if (!artists.containsKey(artistId)){
            artists[artistId] = artista
        }
    }
    fun getArtist(artistId: Int) : ArtistResponse? {
        return if (artists.containsKey(artistId)) artists[artistId]!! else null
    }
}