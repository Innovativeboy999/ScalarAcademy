package com.example.scalaracademy.data.api

import com.example.scalaracademy.data.models.albummodels.AlbumResponseItem
import com.example.scalaracademy.data.models.usermodels.UserResponseItem
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface ScalarInterface {

    @GET("users")
    fun getUsersList() : Single<List<UserResponseItem>>

    @GET("albums")
    fun getAlbumList(@Query("userId") userId : Int) : Single<List<AlbumResponseItem>>

    //https://jsonplaceholder.typicode.com/photos?albumId=2
    @GET("photos")
    fun getPhotos(@Query("albumId") userId : Int)
}