package com.android.vlad.jsonplacerholderdemo.comments.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.android.vlad.jsonplacerholderdemo.model.Comment

@Dao
interface CommentDao {

    @Query("SELECT * FROM comment_table WHERE postId = :id")
    fun getComments(id: String): LiveData<List<Comment>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(posts: List<Comment>)
}