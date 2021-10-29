package com.example.api_libs

import android.os.Bundle
import android.util.Log
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.api_libs.brokers.*
import com.example.api_libs.databinding.ActivityAlbumsListBinding
import com.example.api_libs.models.albumResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AlbumsListActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAlbumsListBinding
    lateinit var retrofitApi: RetrofitApi

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val service = getRetroFitApi().create(RetrofitApiService::class.java)
        val call = service.getAlbums()
        call.enqueue(object : Callback<List<albumResponse>>{

            override fun onResponse(call: Call<List<albumResponse>>, response: Response<List<albumResponse>>) {
                if (!response.isSuccessful()) {
                    return;
                }
                if (response.code() == 200) {
                    val respuesta = response.body()!!

                    val stringBuilder = "Id: " +
                            respuesta[0].id
                }
            }

            override fun onFailure(call: Call<List<albumResponse>>, t: Throwable) {
               t.message
            }
        })

        binding = ActivityAlbumsListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Get the Intent that started this activity and extract the string
        val message = intent.getStringExtra(EXTRA_MESSAGE)

        val navController = findNavController(R.id.nav_host_fragment_content_albums_list)

        binding.fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }
    }
}