package com.vinylsMobile.vinylsapplication.ui.main.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

import com.vinylsMobile.vinylsapplication.data.model.AlbumResponse
import com.vinylsMobile.vinylsapplication.data.model.ArtistResponse
import com.vinylsMobile.vinylsapplication.databinding.ItemLayoutBinding
import com.vinylsMobile.vinylsapplication.ui.main.view.DetailAlbumActivity
import java.util.*
import kotlin.collections.ArrayList

const val IDArtista = "id"

class ArtistAdapter (private val artists: ArrayList<ArtistResponse>
) : RecyclerView.Adapter<ArtistAdapter.DataViewHolder>() {

    lateinit var context : Context


    class DataViewHolder(binding: ItemLayoutBinding) : RecyclerView.ViewHolder(binding.root) {
        val bindPar = binding;
        fun bind(artist: ArtistResponse) {
            bindPar.root.apply {
                bindPar.textViewAlbumName.text = artist.name
                bindPar.textViewUserEmail.text = if(artist.birthDate==null) "Banda" else "Musico"
                Glide.with(bindPar.imageViewAvatar.context)
                    .load(artist.image)
                    .into(bindPar.imageViewAvatar)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder {
        context = parent.context
        val binding = ItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return DataViewHolder(binding)
    }

    override fun getItemCount(): Int = artists.size

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
        holder.bindPar.root.setOnClickListener {
            //Log.d("hola"," mundo")
    //        val intent = Intent(context, DetailAlbumActivity::class.java).apply {
      //          putExtra(ID, artists[position].id.toString())
      //      }

     //       context.startActivity(intent)

        }

        holder.bind(artists[position])
    }

    fun addArtists(artists: List<ArtistResponse>) {
        this.artists.apply {
            clear()
            addAll(artists)
        }

    }
}