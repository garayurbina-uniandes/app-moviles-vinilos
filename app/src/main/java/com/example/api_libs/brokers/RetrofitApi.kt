package com.example.api_libs.brokers

import com.example.api_libs.models.albumResponse
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.*

private const val BASE_URL =
    "https://vinyl-miso.herokuapp.com/"

private val retrofit = Retrofit.Builder()
    .addConverterFactory(GsonConverterFactory.create())
    .baseUrl(BASE_URL)
    .build()


interface RetrofitApiService {
    @GET("albums")
    fun getAlbums():Call<List<albumResponse>>
}

object RetrofitApi {
    val retrofitService : RetrofitApiService by lazy {
        retrofit.create(RetrofitApiService::class.java) }
}

fun getRetroFitApi():Retrofit{
    return retrofit
}