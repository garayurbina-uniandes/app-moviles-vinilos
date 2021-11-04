package com.vinylsMobile.vinylsapplication.ui.main.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.vinylsMobile.vinylsapplication.R
import com.vinylsMobile.vinylsapplication.data.model.albumResponse
import com.vinylsMobile.vinylsapplication.databinding.ActivityMainBinding
import com.vinylsMobile.vinylsapplication.databinding.ItemLayoutBinding


class MainAdapter (private val albums: ArrayList<albumResponse>
) : RecyclerView.Adapter<MainAdapter.DataViewHolder>() {


    class DataViewHolder(binding: ItemLayoutBinding) : RecyclerView.ViewHolder(binding.root) {
        val bindPar = binding;
        fun bind(album: albumResponse) {
            bindPar.textViewAlbumName.text = album.name
            bindPar.textViewUserEmail.text = album.recordLabel
            Glide.with(bindPar.imageViewAvatar.context)
                .load(album.cover)
                .into(bindPar.imageViewAvatar)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):DataViewHolder {

        val binding = ItemLayoutBinding.inflate(LayoutInflater.from(parent.context) ,parent, false )

        return DataViewHolder(binding)
    }

    override fun getItemCount(): Int = albums.size

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) =
        holder.bind(albums[position])

    fun addData(list: List<albumResponse>) {
        albums.addAll(list)
    }

}