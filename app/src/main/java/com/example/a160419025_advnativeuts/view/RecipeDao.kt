package com.example.a160419025_advnativeuts.view

import androidx.room.*
import com.example.a160419025_advnativeuts.model.Recipe

@Dao
interface RecipeDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(vararg recipe: Recipe)

    @Query("SELECT * FROM recipe")
    suspend fun selectAllRecipe(): List<Recipe>

    @Query("SELECT * FROM recipe WHERE uuid = :id")
    suspend fun selectRecipe(id: Int): Recipe

    @Query("UPDATE recipe SET name= :name, recipe= :recipe, thumbnail= :thumbnail, publishedby= :publishedby WHERE uuid= :id")
    suspend fun updateRecipe(name: String, recipe: String, thumbnail: String, publishedby: String, id: Int)

    @Delete
    suspend fun deleteRecipe(recipe: Recipe)
}