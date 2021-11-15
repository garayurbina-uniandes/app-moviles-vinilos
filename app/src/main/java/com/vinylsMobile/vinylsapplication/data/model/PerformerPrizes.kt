package com.vinylsMobile.vinylsapplication.data.model

import com.google.gson.annotations.SerializedName
import java.util.*

class PerformerPrizes {
    @SerializedName("id")
    lateinit var id: Number
    @SerializedName("description")
    var premiationDate: Date? = null
}