package com.android.vlad.jsonplacerholderdemo.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "user_table")
data class User(
    @PrimaryKey
    @field:SerializedName("id")
    val id: String,
    @field:SerializedName("name")
    val name: String,
    @field:SerializedName("username")
    val userName: String,
    @field:SerializedName("email")
    val email: String,
    @field:SerializedName("phone")
    val phone: String,
    @field:SerializedName("website")
    val webSite: String
)