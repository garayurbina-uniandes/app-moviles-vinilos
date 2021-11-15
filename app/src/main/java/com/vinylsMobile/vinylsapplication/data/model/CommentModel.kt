package com.vinylsMobile.vinylsapplication.data.model

import com.google.gson.annotations.SerializedName
import java.util.*

class CommentModel {
    @SerializedName("id")
    lateinit var id: Number
    @SerializedName("description")
    var name: String? = null
    @SerializedName("rating")
    lateinit var rating: Number
}