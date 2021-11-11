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
import com.vinylsMobile.vinylsapplication.databinding.FragmentAlbumListBinding
import com.vinylsMobile.vinylsapplication.databinding.FragmentArtistListBinding
import com.vinylsMobile.vinylsapplication.databinding.FragmentCollectorListBinding
import com.vinylsMobile.vinylsapplication.ui.base.ViewModelFactory
import com.vinylsMobile.vinylsapplication.ui.main.adapter.MainAdapter
import com.vinylsMobile.vinylsapplication.ui.main.viewmodel.MainViewModel
import com.vinylsMobile.vinylsapplication.utils.Status

/**
 * A simple [Fragment] subclass.
 * Use the [CollectorListFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class CollectorListFragment : Fragment() {

    private lateinit var binding:FragmentCollectorListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentCollectorListBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment CollectorListFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance() :CollectorListFragment {
            return CollectorListFragment()
            }
    }

}