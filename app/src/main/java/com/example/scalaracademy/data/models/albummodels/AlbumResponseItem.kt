package com.example.scalaracademy.data.models.albummodels


import com.google.gson.annotations.SerializedName

data class AlbumResponseItem(
    val id: Int,
    val title: String,
    val userId: Int
)