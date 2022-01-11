package com.example.suitmediatest.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.suitmediatest.data.Repository
import com.example.suitmediatest.data.model.Data
import com.example.suitmediatest.data.model.ResponseData
import com.example.suitmediatest.utils.DataDummy
import kotlinx.coroutines.launch
import retrofit2.Response

class MainViewModel(private val repository: Repository) : ViewModel() {

    val myResponse : MutableLiveData<Response<ResponseData>> = MutableLiveData()

    fun getData(){
        viewModelScope.launch {
            val response = repository.getData()
            myResponse.value = response
        }
    }

    fun setName(name : String){
        DataDummy.setName(name)
    }

    fun getName() : String {
        return DataDummy.getName()
    }

    fun setSelectedName(selectedname : String){
        DataDummy.setSelectedName(selectedname)
    }
    fun getSelectedName() : String{
        return DataDummy.getSelectedName()
    }
}