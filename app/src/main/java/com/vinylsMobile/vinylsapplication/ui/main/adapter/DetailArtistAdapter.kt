package com.vinylsMobile.vinylsapplication.ui.main.adapter


import android.util.Log
import android.widget.TableLayout
import android.widget.TableRow
import android.widget.TextView
import com.bumptech.glide.Glide

import com.vinylsMobile.vinylsapplication.data.model.AlbumResponse
import com.vinylsMobile.vinylsapplication.data.model.ArtistResponse
import com.vinylsMobile.vinylsapplication.databinding.ActivityDetailAlbumBinding
import com.vinylsMobile.vinylsapplication.databinding.ActivityDetailArtistBinding

class DetailArtistAdapter (private val artistDetail: ArtistResponse,private val isBand: Boolean)  {

    fun adaptData(binding: ActivityDetailArtistBinding) {
        Glide.with(binding.imageViewArtist.context)
            .load(artistDetail.image)
            .into(binding.imageViewArtist)
        binding.textContentArtist.text=artistDetail.name
        binding.textContentDate.text=if(isBand)artistDetail.creationDate.toString()else artistDetail.birthDate.toString()
        binding.textContentDescrption.text=artistDetail.description
        adaptTablePrizes(binding)
        adaptTableALbums(binding)

        }

    private fun adaptTableALbums(binding: ActivityDetailArtistBinding){
        var row = TableRow(binding.root.context)

        val nombreAlbum = TextView(binding.root.context)
        val generoAlbum = TextView(binding.root.context)

        for (i in artistDetail.albums) {
            nombreAlbum.setText(i.name)
            generoAlbum.setText(i.genre)

            row.addView(nombreAlbum)
            row.addView(generoAlbum)
            binding.tableMain.addView(row)
        }
    }

    private fun adaptTablePrizes(binding: ActivityDetailArtistBinding){
        var row = TableRow(binding.root.context)

        val fecha = TextView(binding.root.context)
        for (i in artistDetail.performerPrizes) {
            fecha.setText(i.premiationDate.toString())

            row.addView(fecha)
            binding.tablePrizes.addView(row)
        }
    }
    }
