package com.example.scalaracademy.data.models.usermodels


import com.google.gson.annotations.SerializedName

data class UserResponseItem(
    val address: Address,
    val company: Company,
    val email: String,
    val id: Int,
    val name: String,
    val phone: String,
    val username: String,
    val website: String
)