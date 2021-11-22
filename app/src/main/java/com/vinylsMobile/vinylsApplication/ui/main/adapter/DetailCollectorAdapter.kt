package com.vinylsMobile.vinylsApplication.ui.main.adapter


import android.annotation.SuppressLint
import android.util.Log
import android.util.Log.ERROR
import android.widget.TableRow
import android.widget.TextView
import com.bumptech.glide.Glide
import com.vinylsMobile.vinylsApplication.data.model.ArtistResponse
import com.vinylsMobile.vinylsApplication.data.model.CollectorResponse
import com.vinylsMobile.vinylsApplication.databinding.ActivityDetailCollectorBinding
import okhttp3.internal.platform.Platform.INFO
import java.text.DateFormat
import java.util.*
const val IdCollector = "id"

class DetailCollectorAdapter(private val collectorDetail: CollectorResponse) {


    @SuppressLint("SetTextI18n")
    fun adaptData(binding: ActivityDetailCollectorBinding) {
        binding.textContentCollector.text = "${collectorDetail.name}"
        binding.contentFavoritePerformers.text = adaptStringFavoritePerformers(binding)
        binding.textContentComments.text = adaptStringComments(binding)


    }

    private fun adaptStringFavoritePerformers(binding: ActivityDetailCollectorBinding): String {
            val sb = StringBuilder()
            for (i in collectorDetail.favoritePerformers) {
                sb.append( "- ${i.name}" + "\n")
            }
            return sb.toString()
        }
    private fun adaptStringComments(binding: ActivityDetailCollectorBinding): String {
        val sb = StringBuilder()
        Log.e("***", collectorDetail.comments.size.toString())
        for (i in collectorDetail.comments){
            sb.append( "- ${i.description}" + " ${i.rating}" + "\n")
        }
        return sb.toString()
    }

}
