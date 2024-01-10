package com.example.fragment5

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

open class DataModel : ViewModel() {
    val message2Activity: MutableLiveData<String> by lazy{
        MutableLiveData<String>()
    }
    val message2Fragment1: MutableLiveData<String> by lazy{
        MutableLiveData<String>()
    }
    val message2Fragment2: MutableLiveData<String> by lazy{
        MutableLiveData<String>()
    }
}