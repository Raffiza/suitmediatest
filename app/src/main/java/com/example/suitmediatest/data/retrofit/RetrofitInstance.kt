package com.example.suitmediatest.data.retrofit

import com.example.suitmediatest.utils.Constant.Companion.BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {

    private val retrofit by lazy {
        Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
    }

    val api : ApiInterface by lazy {
        retrofit.create(ApiInterface::class.java)
    }
}