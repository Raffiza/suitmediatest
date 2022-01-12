package com.example.suitmediatest.data.retrofit

import com.example.suitmediatest.data.model.Data
import com.example.suitmediatest.data.model.ResponseData
import com.example.suitmediatest.utils.Constant.Companion.END_POINT
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET

interface ApiInterface {

    @GET(value = END_POINT)
    suspend fun getData() : Response<ResponseData>
}