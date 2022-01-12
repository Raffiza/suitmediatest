package com.example.suitmediatest.data.model

import com.google.gson.annotations.SerializedName

data class ResponseData (
    val page : Int? = null,
    val per_page : Int? = null,
    val total :Int? = null,
    val total_pages : Int? = null,
    val data : List<Data>? = null
)