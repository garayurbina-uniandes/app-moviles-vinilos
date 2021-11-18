package com.vinylsMobile.vinylsapplication.data.model

import com.google.gson.annotations.SerializedName
import java.util.*
import kotlin.collections.ArrayList

class CollectorResponse {
    @SerializedName("id")
    var id: Number= 0
    @SerializedName("name")
    var name: String? = null
    @SerializedName("telephone")
    var telephone: String? = null
    @SerializedName("email")
    var email: String? = null
    @SerializedName("comments")
    var comments: ArrayList<CommentModel> = ArrayList()
    @SerializedName("favoritePerformers")
    var favoritePerformers: ArrayList<ArtistResponse> = ArrayList()
    @SerializedName("collectorAlbums")
    var collectorAlbums: ArrayList<AlbumResponse> = ArrayList()
}