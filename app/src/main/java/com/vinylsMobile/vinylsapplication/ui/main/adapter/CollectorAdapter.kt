package com.vinylsMobile.vinylsapplication.ui.main.adapter

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

import com.vinylsMobile.vinylsapplication.data.model.AlbumResponse
import com.vinylsMobile.vinylsapplication.data.model.ArtistResponse
import com.vinylsMobile.vinylsapplication.data.model.CollectorResponse
import com.vinylsMobile.vinylsapplication.databinding.ItemLayoutBinding
import com.vinylsMobile.vinylsapplication.ui.main.view.DetailAlbumActivity
import com.vinylsMobile.vinylsapplication.ui.main.view.DetailArtistActivity
import java.util.*
import kotlin.collections.ArrayList

class CollectorAdapter (private val collectors: ArrayList<CollectorResponse>
) : RecyclerView.Adapter<CollectorAdapter.DataViewHolder>() {

    lateinit var context : Context

    class DataViewHolder(binding: ItemLayoutBinding) : RecyclerView.ViewHolder(binding.root) {
        val bindPar = binding;
        fun bind(collector: CollectorResponse) {
            bindPar.root.apply {
                bindPar.textViewAlbumName.text = collector.name
                bindPar.textViewUserEmail.text = collector.email
                Glide.with(bindPar.imageViewAvatar.context)
                    .load(collector.favoritePerformers[0].image)
                    .into(bindPar.imageViewAvatar)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder {
        context = parent.context
        val binding = ItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return DataViewHolder(binding)
    }

    override fun getItemCount(): Int = collectors.size

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {

        holder.bind(collectors[position])
    }

    fun addCollectors(collectors: List<CollectorResponse>) {
        this.collectors.apply {
            clear()
            addAll(collectors)
        }

    }
}