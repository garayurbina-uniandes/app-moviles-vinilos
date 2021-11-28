package com.vinylsMobile.vinylsApplication.ui.main.view

import android.R
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import com.vinylsMobile.vinylsApplication.data.api.ApiHelper
import com.vinylsMobile.vinylsApplication.data.api.RetrofitBuilder
import com.vinylsMobile.vinylsApplication.data.model.ArtistResponse
import com.vinylsMobile.vinylsApplication.data.model.CollectorResponse
import com.vinylsMobile.vinylsApplication.databinding.ActivityDetailArtistBinding
import com.vinylsMobile.vinylsApplication.databinding.ActivityDetailCollectorBinding
import com.vinylsMobile.vinylsApplication.ui.base.ArtistViewModelFactory
import com.vinylsMobile.vinylsApplication.ui.base.CollectorViewModelFactory
import com.vinylsMobile.vinylsApplication.ui.main.adapter.*
import com.vinylsMobile.vinylsApplication.ui.main.viewmodel.ArtistViewModel
import com.vinylsMobile.vinylsApplication.ui.main.viewmodel.CollectorViewModel
import com.vinylsMobile.vinylsApplication.utils.Status

class DetailCollectorActivity : AppCompatActivity() {
    private lateinit var collectorViewModel: CollectorViewModel
    private lateinit var adapter: DetailCollectorAdapter

    private lateinit var binding: ActivityDetailCollectorBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDetailCollectorBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)
        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        setupViewModel()
        setupCollectorObservers(intent.getStringExtra(IdCollector)!!)


    }

    private fun setupViewModel() {
        collectorViewModel = ViewModelProviders.of(
            this,
            CollectorViewModelFactory(ApiHelper(RetrofitBuilder.apiService))
        )[CollectorViewModel::class.java]
    }

    private fun setupCollectorObservers(id: String) {
        collectorViewModel.getCollectorsDetail(id).observe(this, {
            it?.let { resource ->
                when (resource.status) {
                    Status.SUCCESS -> {
                        resource.data?.let { collectorDetail ->
                            retrieveCollectorDetail(
                                collectorDetail
                            )
                        }
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

    private fun retrieveCollectorDetail(collector: CollectorResponse) {
        supportActionBar?.title = collector.name
        supportActionBar?.subtitle = "Coleccionista"
        adapter = DetailCollectorAdapter(collector)
        adapter.adaptData(binding)

    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.home -> {
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