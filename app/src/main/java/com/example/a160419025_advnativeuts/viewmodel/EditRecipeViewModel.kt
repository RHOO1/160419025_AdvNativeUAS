package com.example.a160419025_advnativeuts.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.a160419025_advnativeuts.model.Recipe
import com.example.a160419025_advnativeuts.util.buildDB
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class EditRecipeViewModel(application: Application): AndroidViewModel(application), CoroutineScope {
    private val job = Job()
    val recipeLD = MutableLiveData<Recipe>()

    fun update(name: String, recipe: String, thumbnail: String, publishedby: String, id: Int) {
        launch {
            val db = buildDB(getApplication())

            db.recipeDao().updateRecipe(name, recipe, thumbnail, publishedby, id)
        }
    }

    override val coroutineContext: CoroutineContext
        get() = job + Dispatchers.Main
}