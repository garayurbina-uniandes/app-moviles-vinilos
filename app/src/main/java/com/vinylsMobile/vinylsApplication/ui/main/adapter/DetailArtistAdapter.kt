package com.vinylsMobile.vinylsApplication.ui.main.adapter


import android.widget.TableRow
import android.widget.TextView
import com.bumptech.glide.Glide
import com.vinylsMobile.vinylsApplication.data.model.ArtistResponse
import com.vinylsMobile.vinylsApplication.databinding.ActivityDetailArtistBinding
import java.text.DateFormat
import java.util.*

class DetailArtistAdapter(private val artistDetail: ArtistResponse, private val isBand: Boolean) {

    fun adaptData(binding: ActivityDetailArtistBinding) {
        Glide.with(binding.imageViewArtist.context)
            .load(artistDetail.image)
            .into(binding.imageViewArtist)
        binding.textContentArtist.text = artistDetail.name
        binding.textContentDate.text =
            if (isBand) formatDate(artistDetail.creationDate) else formatDate(artistDetail.birthDate).toString()
        binding.textContentDescription.text = artistDetail.description
        adaptTablePrizes(binding)
        adaptTableALbums(binding)

    }

    private fun formatDate(date: Date?): String {
        return DateFormat.getDateInstance(DateFormat.LONG).format(date).toString()
    }


    private fun adaptTableALbums(binding: ActivityDetailArtistBinding) {
        val row = TableRow(binding.root.context)

        val nombreAlbum = TextView(binding.root.context)
        val generoAlbum = TextView(binding.root.context)

        for (i in artistDetail.albums) {
            nombreAlbum.text = i.name
            generoAlbum.text = i.genre

            row.addView(nombreAlbum)
            row.addView(generoAlbum)
            binding.tableMain.addView(row)
        }
    }

    private fun adaptTablePrizes(binding: ActivityDetailArtistBinding) {
        val row = TableRow(binding.root.context)

        val fecha = TextView(binding.root.context)
        for (i in artistDetail.performerPrizes) {
            fecha.text = i.premiationDate.toString()

            row.addView(fecha)
            binding.tablePrizes.addView(row)
        }
    }
}
