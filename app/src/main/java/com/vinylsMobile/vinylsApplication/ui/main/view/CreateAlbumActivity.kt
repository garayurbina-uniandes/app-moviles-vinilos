package com.vinylsMobile.vinylsApplication.ui.main.view

import android.R
import android.app.DatePickerDialog
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import com.vinylsMobile.vinylsApplication.data.api.ApiHelper
import com.vinylsMobile.vinylsApplication.data.api.RetrofitBuilder
import com.vinylsMobile.vinylsApplication.databinding.ActivityCreateAlbumBinding
import com.vinylsMobile.vinylsApplication.ui.base.ViewModelFactory
import com.vinylsMobile.vinylsApplication.ui.main.viewmodel.MainViewModel

class CreateAlbumActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCreateAlbumBinding
    private lateinit var mainViewModel: MainViewModel

    private var datePickerDialog: DatePickerDialog? = null
    private var selected_date: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCreateAlbumBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupViewModel()
    }

    private fun setupViewModel() {
        mainViewModel = ViewModelProviders.of(
            this,
            ViewModelFactory(ApiHelper(RetrofitBuilder.apiService))
        )[MainViewModel::class.java]
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
