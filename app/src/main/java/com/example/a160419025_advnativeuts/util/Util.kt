package com.example.a160419025_advnativeuts.util

import android.content.Context
import android.widget.ImageView
import android.widget.ProgressBar
import androidx.appcompat.R
import androidx.databinding.BindingAdapter
import androidx.room.Room
import com.example.a160419025_advnativeuts.model.RecipeDatabase
import com.squareup.picasso.Picasso

val DB_Name = "recipedb"

fun buildDB(context: Context): RecipeDatabase {
    val db = Room.databaseBuilder(
        context,
        RecipeDatabase::class.java,
        DB_Name
    ).build()

    return db
}

fun ImageView.loadImage(url: String?) {
    Picasso.get()
        .load(url)
        .resize(400, 400)
        .centerCrop()
        .into(this)
}

@BindingAdapter("android:imageUrl")
fun loadPhotoURL(view: ImageView, url: String) {
    view.loadImage(url)
}
