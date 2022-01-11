package com.example.suitmediatest.utils

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.suitmediatest.data.Repository
import com.example.suitmediatest.ui.MainViewModel

class MainViewModelFactory (private val repository: Repository) : ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MainViewModel(repository) as T
    }


}