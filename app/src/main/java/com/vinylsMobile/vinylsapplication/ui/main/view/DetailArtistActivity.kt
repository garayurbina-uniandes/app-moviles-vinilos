package com.vinylsMobile.vinylsapplication.ui.main.view

import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.vinylsMobile.vinylsapplication.data.api.ApiHelper
import com.vinylsMobile.vinylsapplication.data.api.RetrofitBuilder
import com.vinylsMobile.vinylsapplication.data.model.AlbumResponse
import com.vinylsMobile.vinylsapplication.data.model.ArtistResponse
import com.vinylsMobile.vinylsapplication.databinding.ActivityDetailAlbumBinding
import com.vinylsMobile.vinylsapplication.databinding.ActivityDetailArtistBinding
import com.vinylsMobile.vinylsapplication.ui.base.ArtistViewModelFactory
import com.vinylsMobile.vinylsapplication.ui.base.ViewModelFactory
import com.vinylsMobile.vinylsapplication.ui.main.adapter.*
import com.vinylsMobile.vinylsapplication.ui.main.viewmodel.ArtistViewModel
import com.vinylsMobile.vinylsapplication.ui.main.viewmodel.MainViewModel
import com.vinylsMobile.vinylsapplication.utils.Status

class DetailArtistActivity : AppCompatActivity() {
    private lateinit var artistViewModel: ArtistViewModel
    private lateinit var adapter: DetailArtistAdapter

    private lateinit var binding: ActivityDetailArtistBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDetailArtistBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)
        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true);
        val artistType = intent.getStringExtra(artist)!!

        setupViewModel()

        if (artistType=="Banda"){
            setupBandObservers(intent.getStringExtra(IDArtista)!!)
        }
        else{
            setupMusiciansObservers(intent.getStringExtra(IDArtista)!!)
        }

    }

    private fun setupViewModel() {
        artistViewModel = ViewModelProviders.of(
            this,
            ArtistViewModelFactory(ApiHelper(RetrofitBuilder.apiService))
        ).get(ArtistViewModel::class.java)
    }

    private fun setupMusiciansObservers(id:String) {
        artistViewModel.getMusiciansDetail(id).observe(this, Observer {
            it?.let { resource ->
                when (resource.status) {
                    Status.SUCCESS -> {
                        resource.data?.let { artistDetail -> retrieveArtistDetail(artistDetail,false) }
                    }
                    Status.ERROR -> {
                        Toast.makeText(this, it.message, Toast.LENGTH_LONG).show()
                    }
                    Status.LOADING -> {
                    }
                }
            }
        })
    }

    private fun setupBandObservers(id:String) {
        artistViewModel.getBandsDetail(id).observe(this, Observer {
            it?.let { resource ->
                when (resource.status) {
                    Status.SUCCESS -> {
                        resource.data?.let { artistDetail -> retrieveArtistDetail(artistDetail,true) }
                    }
                    Status.ERROR -> {
                        Toast.makeText(this, it.message, Toast.LENGTH_LONG).show()
                    }
                    Status.LOADING -> {
                    }
                }
            }
        })
    }

    private fun retrieveArtistDetail(artist: ArtistResponse,isBand: Boolean) {
        supportActionBar?.title =artist.name
        adapter = DetailArtistAdapter(artist,isBand)
        adapter.adaptData(binding)

    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                finish()
                return true
            }
        }
        return super.onContextItemSelected(item)
    }


}