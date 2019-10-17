package com.android.vlad.jsonplacerholderdemo.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "comment_table")
data class Comment(
    @field:SerializedName("postId")
    val postId: String,
    @PrimaryKey
    @field:SerializedName("id")
    val id: String,
    @field:SerializedName("name")
    val name: String,
    @field:SerializedName("email")
    val email: String,
    @field:SerializedName("body")
    val body: String
)
