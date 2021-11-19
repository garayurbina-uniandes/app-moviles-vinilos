package com.vinylsMobile.vinylsApplication.ui.main.adapter


import com.bumptech.glide.Glide

import com.vinylsMobile.vinylsApplication.data.model.AlbumResponse
import com.vinylsMobile.vinylsApplication.databinding.ActivityDetailAlbumBinding

class DetailAdapter (private val albumDetail: AlbumResponse)  {

    fun adaptData(binding: ActivityDetailAlbumBinding) {
        Glide.with(binding.imageView2.context)
            .load(albumDetail.cover)
            .into(binding.imageView2)
        binding.textContentDate.text=albumDetail.releaseDate.toString()
        binding.textContentGenre.text=albumDetail.genre
        binding.textContentRecord.text=albumDetail.recordLabel
        binding.textContentDescription.text=albumDetail.description
    }
}