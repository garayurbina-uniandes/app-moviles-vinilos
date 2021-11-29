package com.vinylsMobile.vinylsApplication.data.model

import com.google.gson.JsonObject
import com.google.gson.annotations.SerializedName

class TracksResponse(name: String, duration: String) {

    @SerializedName("id")
    var id: Number = 0

    @SerializedName("name")
    var name: String? = null

    @SerializedName("duration")
    var duration: String? = null

    fun jsonPostString() : JsonObject {
        val paramObject = JsonObject()
        paramObject.addProperty("name", this.name)
        paramObject.addProperty("duration", this.duration)
        return paramObject
    }

}
