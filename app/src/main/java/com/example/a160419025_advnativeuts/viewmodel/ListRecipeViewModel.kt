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

class ListRecipeViewModel (application: Application): AndroidViewModel(application), CoroutineScope {
    val recipeLD = MutableLiveData<List<Recipe>>()
    val recipeLoadErrorLD = MutableLiveData<Boolean>()
    val loadingLD = MutableLiveData<Boolean>()
    private var job = Job()

    override val coroutineContext: CoroutineContext
        get() = job + Dispatchers.Main

    fun refresh() {
        loadingLD.value = true
        recipeLoadErrorLD.value = false

        launch {
            val db = buildDB(getApplication())

            recipeLD.value = db.recipeDao().selectAllRecipe()
        }
    }

    fun clearTask(recipe: Recipe) {
        launch {
            val db = buildDB(getApplication())
            db.recipeDao().deleteRecipe(recipe)

            recipeLD.value = db.recipeDao().selectAllRecipe()
        }
    }
}