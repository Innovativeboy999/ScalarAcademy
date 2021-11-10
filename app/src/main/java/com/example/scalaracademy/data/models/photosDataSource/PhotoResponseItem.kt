package com.example.scalaracademy.data.models.photosDataSource


import com.google.gson.annotations.SerializedName

data class PhotoResponseItem(
    val albumId: Int,
    val id: Int,
    val thumbnailUrl: String,
    val title: String,
    val url: String
)