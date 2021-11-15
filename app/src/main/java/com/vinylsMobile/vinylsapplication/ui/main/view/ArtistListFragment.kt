package com.vinylsMobile.vinylsapplication.ui.main.view

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.vinylsMobile.vinylsapplication.data.api.ApiHelper
import com.vinylsMobile.vinylsapplication.data.api.RetrofitBuilder
import com.vinylsMobile.vinylsapplication.data.model.AlbumResponse
import com.vinylsMobile.vinylsapplication.data.model.ArtistResponse
import com.vinylsMobile.vinylsapplication.databinding.FragmentAlbumListBinding
import com.vinylsMobile.vinylsapplication.databinding.FragmentArtistListBinding
import com.vinylsMobile.vinylsapplication.ui.base.ArtistViewModelFactory
import com.vinylsMobile.vinylsapplication.ui.base.ViewModelFactory
import com.vinylsMobile.vinylsapplication.ui.main.adapter.ArtistAdapter
import com.vinylsMobile.vinylsapplication.ui.main.adapter.MainAdapter
import com.vinylsMobile.vinylsapplication.ui.main.viewmodel.ArtistViewModel
import com.vinylsMobile.vinylsapplication.ui.main.viewmodel.MainViewModel
import com.vinylsMobile.vinylsapplication.utils.Status

/**
 * A simple [Fragment] subclass.
 * Use the [ArtistListFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ArtistListFragment : Fragment() {
    private lateinit var artistViewModel: ArtistViewModel
    private lateinit var adapter: ArtistAdapter
    private lateinit var binding:FragmentArtistListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    private fun setupUI() {
        binding.recyclerViewArtist.layoutManager = LinearLayoutManager(this.context)
        adapter = ArtistAdapter(arrayListOf())
        binding.recyclerViewArtist.addItemDecoration(
            DividerItemDecoration(
                binding.recyclerViewArtist.context,
                (binding.recyclerViewArtist.layoutManager as LinearLayoutManager).orientation
            )
        )
        binding.recyclerViewArtist.adapter = adapter
    }

    private fun setupObservers() {
        artistViewModel.getArtists().observe(viewLifecycleOwner, Observer {
            it?.let { resource ->
                when (resource.status) {
                    Status.SUCCESS -> {
                        binding.recyclerViewArtist.visibility = View.VISIBLE
                        binding.progressBarArtist.visibility = View.GONE
                        resource.data?.let { musicians -> retrieveList(musicians) }
                    }
                    Status.ERROR -> {
                        binding.recyclerViewArtist.visibility = View.VISIBLE
                        binding.progressBarArtist.visibility = View.GONE
                        Toast.makeText(this.context, it.message, Toast.LENGTH_LONG).show()
                    }
                    Status.LOADING -> {
                        binding.progressBarArtist.visibility = View.VISIBLE
                        binding.recyclerViewArtist.visibility = View.GONE
                    }
                }
            }
        })
    }

    private fun setupViewModel() {
        artistViewModel = ViewModelProviders.of(
            this,
            ArtistViewModelFactory(ApiHelper(RetrofitBuilder.apiService))
        ).get(ArtistViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentArtistListBinding.inflate(layoutInflater, container, false)
        setupUI()
        setupViewModel()
        setupObservers()
        return binding.root
    }

    private fun retrieveList(artists: List<ArtistResponse>) {
        adapter.apply {
            addArtists(artists)
            notifyDataSetChanged()
        }
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @return A new instance of fragment ArtistListFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance() :ArtistListFragment {
            return ArtistListFragment()
            }
    }

}