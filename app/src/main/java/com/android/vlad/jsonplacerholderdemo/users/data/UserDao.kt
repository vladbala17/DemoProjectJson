package com.android.vlad.jsonplacerholderdemo.users.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.android.vlad.jsonplacerholderdemo.model.User

@Dao
interface UserDao {
    @Query("SELECT * FROM user_table ")
    fun getUsers(): LiveData<List<User>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(users: List<User>)
}