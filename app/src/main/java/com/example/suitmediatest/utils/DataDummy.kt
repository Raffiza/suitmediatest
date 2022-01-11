package com.example.suitmediatest.utils

object DataDummy {
    private var name : String = ""
    private var selectedname : String = "Selected User Name"

    fun setName(name : String){
        this.name = name
    }
    fun getName() : String{
        return this.name
    }

    fun setSelectedName(selectedname : String){
        this.selectedname = selectedname
    }
    fun getSelectedName() : String{
        return this.selectedname
    }
}