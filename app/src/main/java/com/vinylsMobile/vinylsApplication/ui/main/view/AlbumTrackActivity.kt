package com.vinylsMobile.vinylsApplication.ui.main.view

import android.R
import android.os.Bundle
import android.view.MenuItem
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import androidx.lifecycle.lifecycleScope
import com.vinylsMobile.vinylsApplication.data.api.ApiHelper
import com.vinylsMobile.vinylsApplication.data.api.RetrofitBuilder
import com.vinylsMobile.vinylsApplication.databinding.ActivityTrackAlbumBinding
import com.vinylsMobile.vinylsApplication.ui.base.ViewModelFactory
import com.vinylsMobile.vinylsApplication.ui.main.viewmodel.MainViewModel
import kotlinx.coroutines.launch

class AlbumTrackActivity : AppCompatActivity() {

    private lateinit var binding: ActivityTrackAlbumBinding
    private lateinit var mainViewModel: MainViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTrackAlbumBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupViewModel()

        var numberAlbumId: Number = 0
        val albumId = intent.getStringExtra("idAlbum")
        val postButton: Button = binding.btnCreateTrackAlbum
        if (albumId != null) {
            numberAlbumId = (albumId.toInt())
        }

        setSupportActionBar(binding.toolbar)
        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        binding.idAlbum.text = albumId

        postButton.setOnClickListener {
            val name = binding.txtName.text.toString()
            val input_min = binding.textMin.text.toString()
            val input_seg = binding.textSeg.text.toString()

            val duration = "${input_min}:${input_seg}"
            createTrackToAlbum(name, duration, numberAlbumId)
            this.finish()

        }
    }

    private fun setupViewModel() {
        mainViewModel = ViewModelProviders.of(
            this,
            ViewModelFactory(ApiHelper(RetrofitBuilder.apiService))
        )[MainViewModel::class.java]
    }

    private fun createTrackToAlbum(name: String, duration: String, id: Number) {
        lifecycleScope.launch {
            mainViewModel.createTrackToAlbum(name, duration, id)
            val toast =
                Toast.makeText(applicationContext, "Se ha asociado el track", Toast.LENGTH_LONG)
            toast.show()
        }

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

    // Override  supportActionBar?.setDisplayHomeAsUpEnabled , close current activity
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId
        if (id == R.id.home) {
            onBackPressed()
            return true
        }
        return super.onOptionsItemSelected(item)
    }

}