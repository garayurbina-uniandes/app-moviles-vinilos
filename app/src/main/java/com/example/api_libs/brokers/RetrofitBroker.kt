package com.example.api_libs.brokers

import android.util.Log
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RetrofitBroker {
    companion object{
        var test:String = "holaaaaa"
        fun getRequest(onResponse:(resp:String)->Unit, onFailure:(resp:String)->Unit) {
            var r = RetrofitApi.retrofitService.getProperties()
            var p = r.enqueue(
                object : Callback<String> {
                    override fun onFailure(call: Call<String>, t: Throwable) {
                        onFailure(t.message!!)
                    }

                    override fun onResponse(call: Call<String>, response: Response<String>) {
                        onResponse(response.body()!!)
                    }
                })
        }

    }
}