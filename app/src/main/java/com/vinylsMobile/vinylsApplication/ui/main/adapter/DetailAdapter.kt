package com.vinylsMobile.vinylsApplication.ui.main.adapter


import com.bumptech.glide.Glide

import com.vinylsMobile.vinylsApplication.data.model.AlbumResponse
import com.vinylsMobile.vinylsApplication.databinding.ActivityDetailAlbumBinding
import java.text.DateFormat
import java.util.*

class DetailAdapter(private val albumDetail: AlbumResponse) {

    fun adaptData(binding: ActivityDetailAlbumBinding) {
        Glide.with(binding.imageView2.context)
            .load(albumDetail.cover)
            .into(binding.imageView2)
        binding.textContentDate.text = formatDate(albumDetail.releaseDate)
        binding.textContentGenre.text = albumDetail.genre
        binding.textContentRecord.text = albumDetail.recordLabel
        binding.textContentDescription.text = albumDetail.description
    }

    private fun formatDate(date: Date?): String {
        return DateFormat.getDateInstance(DateFormat.LONG).format(date).toString()
    }
}