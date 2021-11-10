package com.vinylsMobile.vinylsapplication.ui.main.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.vinylsMobile.vinylsapplication.ui.main.adapter.MainAdapter
import com.vinylsMobile.vinylsapplication.ui.main.viewmodel.MainViewModel
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import android.view.View
import android.widget.Toast
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupActionBarWithNavController
import com.vinylsMobile.vinylsapplication.data.api.ApiHelper
import com.vinylsMobile.vinylsapplication.data.api.RetrofitBuilder
import com.vinylsMobile.vinylsapplication.data.model.AlbumResponse
import com.vinylsMobile.vinylsapplication.databinding.ActivityMainBinding
import com.vinylsMobile.vinylsapplication.ui.base.ViewModelFactory
import com.vinylsMobile.vinylsapplication.utils.Status


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        val navHostFragment = supportFragmentManager.findFragmentById(binding.navHostFragment.id) as NavHostFragment

        navController = navHostFragment.navController

        setupActionBarWithNavController(navController)
    }
}