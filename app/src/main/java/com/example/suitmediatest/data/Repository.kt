package com.example.suitmediatest.data

import com.example.suitmediatest.data.model.Data
import com.example.suitmediatest.data.model.ResponseData
import com.example.suitmediatest.data.retrofit.RetrofitInstance
import retrofit2.Response

class Repository {

    suspend fun getData() : Response<ResponseData> {
        return RetrofitInstance.api.getData()

    }
}