package com.android.vlad.jsonplacerholderdemo.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "post_table")
data class Post(
    @field:SerializedName("userId")
    val userId: String,
    @PrimaryKey
    @field:SerializedName("id")
    val id: String,
    @field:SerializedName("title")
    val title: String,
    @field:SerializedName("body")
    val body: String
)
