package com.example.a160419025_advnativeuts.model

data class User (
    val username: String?,
    val name: String?,
    val password: String?
)

data class Recipe (
    val id: Int?,
    val name: String?,
    val recipe: String?,
    val thumbnail: String?,
    val publishedby: String?
)