package com.android.vlad.jsonplacerholderdemo.posts.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.android.vlad.jsonplacerholderdemo.model.Post

@Dao
interface PostDao {

    @Query("SELECT * FROM post_table WHERE userId = :id")
    fun getPosts(id: String): LiveData<List<Post>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(posts: List<Post>)
}