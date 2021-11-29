package com.vinylsMobile.vinylsApplication.ui.main.view

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import com.vinylsMobile.vinylsApplication.R
import com.vinylsMobile.vinylsApplication.data.api.ApiHelper
import com.vinylsMobile.vinylsApplication.data.api.RetrofitBuilder
import com.vinylsMobile.vinylsApplication.data.model.AlbumResponse
import com.vinylsMobile.vinylsApplication.databinding.ActivityDetailAlbumBinding
import com.vinylsMobile.vinylsApplication.ui.base.ViewModelFactory
import com.vinylsMobile.vinylsApplication.ui.main.adapter.DetailAdapter
import com.vinylsMobile.vinylsApplication.ui.main.adapter.ID
import com.vinylsMobile.vinylsApplication.ui.main.viewmodel.MainViewModel
import com.vinylsMobile.vinylsApplication.utils.Status

class DetailAlbumActivity : AppCompatActivity() {
    private lateinit var mainViewModel: MainViewModel
    private lateinit var adapter: DetailAdapter

    private lateinit var binding: ActivityDetailAlbumBinding
    private lateinit var idAlbum: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDetailAlbumBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)
        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        val id = intent.getStringExtra(ID)!!
        idAlbum = id

        setupViewModel()
        setupObservers(id)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.submenu_album,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId){
            R.id.nav_album_add_song -> {
                launchAlbumTrackActivityView(idAlbum)
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun setupViewModel() {
        mainViewModel = ViewModelProviders.of(
            this,
            ViewModelFactory(ApiHelper(RetrofitBuilder.apiService))
        )[MainViewModel::class.java]
    }

    private fun setupObservers(id: String) {
        mainViewModel.getAlbumDetail(id).observe(this, {
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
        supportActionBar?.title = album.name
        supportActionBar?.subtitle = "Album"
    }

    private fun launchAlbumTrackActivityView(albumId: String) {
        val intent = Intent(this, AlbumTrackActivity::class.java)
        intent.putExtra("idAlbum", albumId)
        startActivity(intent)
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