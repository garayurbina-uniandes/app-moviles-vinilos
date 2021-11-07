package com.vinylsMobile.vinylsapplication.ui.main.adapter


import com.bumptech.glide.Glide

import com.vinylsMobile.vinylsapplication.data.model.AlbumResponse
import com.vinylsMobile.vinylsapplication.databinding.ActivityDetailAlbumBinding

class DetailAdapter (private val albumDetail: AlbumResponse)  {

    fun adaptData(binding: ActivityDetailAlbumBinding) {
        Glide.with(binding.imageView2.context)
            .load(albumDetail.cover)
            .into(binding.imageView2)
        binding.textViewArtist.text=albumDetail.releaseDate.toString()
        binding.textViewGenre.text=albumDetail.genre
        binding.textViewRecord.text=albumDetail.recordLabel
        binding.textViewDescrption.text=albumDetail.description
    }
}