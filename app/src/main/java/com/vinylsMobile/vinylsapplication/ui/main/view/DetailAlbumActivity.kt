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
import com.vinylsMobile.vinylsapplication.databinding.ActivityDetailAlbumBinding
import com.vinylsMobile.vinylsapplication.ui.base.ViewModelFactory
import com.vinylsMobile.vinylsapplication.ui.main.adapter.DetailAdapter
import com.vinylsMobile.vinylsapplication.ui.main.adapter.ID
import com.vinylsMobile.vinylsapplication.ui.main.viewmodel.MainViewModel
import com.vinylsMobile.vinylsapplication.utils.Status

class DetailAlbumActivity : AppCompatActivity() {
    private lateinit var mainViewModel: MainViewModel
    private lateinit var adapter: DetailAdapter

    private lateinit var binding: ActivityDetailAlbumBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDetailAlbumBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)
        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true);
        val id = intent.getStringExtra(ID)!!

        setupViewModel()
        setupObservers(id)
    }

    private fun setupViewModel() {
        mainViewModel = ViewModelProviders.of(
            this,
            ViewModelFactory(ApiHelper(RetrofitBuilder.apiService))
        ).get(MainViewModel::class.java)
    }

    private fun setupObservers(id:String) {
        mainViewModel.getAlbumDetail(id).observe(this, Observer {
            it?.let { resource ->
                when (resource.status) {
                    Status.SUCCESS -> {
                        resource.data?.let { albumDetail -> retrieveAlbumDetail(albumDetail) }
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

    private fun retrieveAlbumDetail(album: AlbumResponse) {
        adapter = DetailAdapter(album)
        adapter.adaptData(binding)
        supportActionBar?.title =album.name
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