package com.vinylsMobile.vinylsapplication.ui.main.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupActionBarWithNavController
import com.vinylsMobile.vinylsapplication.databinding.ActivityMainBinding
import com.vinylsMobile.vinylsapplication.R


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

        binding.bottomNavigationView.setOnItemSelectedListener {
            when (it.itemId) {
                 binding.bottomNavigationView.menu.getItem(0).itemId-> {
                    setFragment(AlbumListFragment.newInstance())
                    return@setOnItemSelectedListener true
                }
                binding.bottomNavigationView.menu.getItem(1).itemId -> {
                    setFragment(ArtistListFragment.newInstance())
                    return@setOnItemSelectedListener true
                }
                binding.bottomNavigationView.menu.getItem(2).itemId -> {
                    setFragment(CollectorListFragment.newInstance())
                    return@setOnItemSelectedListener true
                }
            }
            false
        }
    }

    private fun setFragment(fr : Fragment){
        val frag = supportFragmentManager.beginTransaction()
        frag.replace(binding.navHostFragment.id,fr).setCustomAnimations(R.anim.slide_in ,R.anim.fade_out,R.anim.fade_in, R.anim.slide_out)
            .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
            .addToBackStack(null)
            .commit()
    }



}