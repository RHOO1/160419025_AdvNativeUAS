package com.example.a160419025_advnativeuts.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.a160419025_advnativeuts.model.Recipe

class ListViewModel: ViewModel() {
    val recipeLD = MutableLiveData<List<Recipe>>()

    fun refresh () {

    }
}