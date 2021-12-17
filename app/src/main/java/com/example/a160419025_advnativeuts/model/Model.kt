package com.example.a160419025_advnativeuts.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

data class User (
    val username: String?,
    val name: String?,
    val password: String?
)

@Entity
data class Recipe (
    @ColumnInfo(name="name")
    val name: String,
    @ColumnInfo(name="recipe")
    val recipe: String,
    @ColumnInfo(name="thumbnail")
    val thumbnail: String,
    @ColumnInfo(name="publishedby")
    val publishedby: String
) {
    @PrimaryKey(autoGenerate = true)
    var uuid: Int = 0
}