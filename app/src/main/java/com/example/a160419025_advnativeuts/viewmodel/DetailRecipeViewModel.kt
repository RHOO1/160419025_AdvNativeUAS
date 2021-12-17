package com.example.a160419025_advnativeuts.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.room.Room
import com.example.a160419025_advnativeuts.model.Recipe
import com.example.a160419025_advnativeuts.model.RecipeDatabase
import com.example.a160419025_advnativeuts.util.buildDB
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class DetailRecipeViewModel(application: Application): AndroidViewModel(application), CoroutineScope {
    private val job = Job()
    val recipeLD = MutableLiveData<Recipe>()

    fun addRecipe(list: List<Recipe>) {
        launch {
            val db = buildDB(getApplication())

            db.recipeDao().insertAll(*list.toTypedArray())
        }
    }

    fun fetch(uuid: Int) {
        launch {
            val db = buildDB(getApplication())

            recipeLD.value = db.recipeDao().selectRecipe(uuid)
        }
    }

    override val coroutineContext: CoroutineContext
        get() = job + Dispatchers.Main
}